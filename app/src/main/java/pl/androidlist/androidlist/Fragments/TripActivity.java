package pl.androidlist.androidlist.Fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import pl.androidlist.androidlist.R;
import pl.androidlist.androidlist.TripsListActivity;

public class TripActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        String departureDate = getIntent().getStringExtra("departure_date");
        String returnDate = getIntent().getStringExtra("return_date");
        String price = getIntent().getStringExtra("price");
        String location = getIntent().getStringExtra("location");
        byte [] image = getIntent().getByteArrayExtra("image");

        setTrip(departureDate, returnDate, price, location, image);
    }

    private void setTrip(String departureDate, String returnDate, String price, String location, byte [] image){
        TextView TripDepartureDate = findViewById(R.id.tripRowDepartureDate);
        TextView TripReturnDate = findViewById(R.id.tripRowReturnDate);
        TextView TripPrice = findViewById(R.id.tripRowPrice);
        TextView TripLocation = findViewById(R.id.tripRowLocation);
        ImageView TripImage = findViewById(R.id.tripRowImageView);

        Bitmap bitmap = BitmapFactory.decodeByteArray(image,0,image.length);

        TripDepartureDate.setText(departureDate);
        TripReturnDate.setText(returnDate);
        TripPrice.setText(price);
        TripLocation.setText(location);
        TripImage.setImageBitmap(bitmap);
    }
}
