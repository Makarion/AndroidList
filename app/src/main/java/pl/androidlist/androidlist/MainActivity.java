package pl.androidlist.androidlist;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageActivity;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;

import pl.androidlist.androidlist.SQLiteConfig.SQLiteHelper;

import static com.theartofdev.edmodo.cropper.CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE;

public class MainActivity extends AppCompatActivity {

    EditText editDepartureDate, editReturnDate, editPrice, editLocation;
    Button btnAddTrip, btnShowTrips;
    ImageView Image;

    static int REQUEST_CODE_GALLERY=999;
    public static SQLiteHelper sqLiteHelper;

    // nadanie uprawnień użytkownikowi aplikacji do dostępu do galerii
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CODE_GALLERY){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent,REQUEST_CODE_GALLERY);
            }
            else{
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    // wstawienie obrazka z galerii
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK){
            Uri imageUri=data.getData();
            CropImage.activity(imageUri).setGuidelines(CropImageView.Guidelines.ON)// guidelines
            .setAspectRatio(1,1)  //kwadratowy obrazek :)
            .start(this);
        }
        if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if(resultCode == RESULT_OK){
                Uri resultUri = result.getUri();
                Image.setImageURI(resultUri);
            }
            else if (resultCode == CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Exception error= result.getError();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editDepartureDate=findViewById(R.id.departureDate);
        editReturnDate=findViewById(R.id.returnDate);
        editPrice=findViewById(R.id.price);
        editLocation=findViewById(R.id.location);
        Image=findViewById(R.id.image);
        btnAddTrip=findViewById(R.id.addTrip);
        btnShowTrips=findViewById(R.id.showTrips);

        sqLiteHelper = new SQLiteHelper(this,"TRIPS-DATABASE.sqlite", null, 1);
        sqLiteHelper.queryData("DROP TABLE TRIPS;");
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS TRIPS(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "departure_date VARCHAR," +
                "return_date VARCHAR," +
                "price VARCHAR," +
                "location VARCHAR,"+
                "image BLOB);");

        Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });

        btnAddTrip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                try{
                    sqLiteHelper.insertData(
                            editDepartureDate.getText().toString().trim(),
                            editReturnDate.getText().toString().trim(),
                            editPrice.getText().toString().trim(),
                            editLocation.getText().toString().trim(),
                            imageViewToByte(Image)
                    );
                    Toast.makeText(MainActivity.this, "Dodano wycieczkę", Toast.LENGTH_SHORT).show();

                    editDepartureDate.setText("");
                    editReturnDate.setText("");
                    editLocation.setText("");
                    editPrice.setText("");
                    Image.setImageResource(R.drawable.photo_icon);

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    private static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, outputStream);
        byte [] imageBytes = outputStream.toByteArray();
        return imageBytes;
    }
}
