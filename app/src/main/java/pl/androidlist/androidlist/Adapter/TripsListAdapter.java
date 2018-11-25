package pl.androidlist.androidlist.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pl.androidlist.androidlist.MainActivity;
import pl.androidlist.androidlist.Model.Wyjazd;
import pl.androidlist.androidlist.R;

/**
 * Created by Makarion on 2018-11-22.
 */

public class TripsListAdapter extends RecyclerView.Adapter<TripsListAdapter.ViewHolder>{

    private Context context;
    Cursor cursor = MainActivity.sqLiteHelper.getData("SELECT * FROM TRIPS");
    private List<Wyjazd> tripsList;
    View.OnClickListener onClickListener;

    public TripsListAdapter(Context context,List<Wyjazd> tripsList) {
        this.context = context;
        this.tripsList = tripsList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);

        RecyclerView.ViewHolder viewHolder = new ViewHolder(v);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onClick(view);
            }
        });

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {


        Wyjazd wyjazd = tripsList.get(position);

        viewHolder.txtDepartureDate.setText(wyjazd.getDataWyjazdu());
        viewHolder.txtReturnDate.setText(wyjazd.getDataPowrotu());
        viewHolder.txtPrice.setText(wyjazd.getCena());
        viewHolder.txtLocation.setText(wyjazd.getDataWyjazdu());

        byte [] recordImage = wyjazd.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(recordImage,0,recordImage.length);
        viewHolder.img.setImageBitmap(bitmap);

        if(!cursor.moveToPosition(position)){
            return;
        }

        int id = cursor.getInt(0);

        viewHolder.itemView.setTag(id);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(context, "onClick na zdjęcie: " + position, Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return tripsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView txtDepartureDate, txtReturnDate, txtPrice, txtLocation;

        public ViewHolder(View row) {
            super(row);

            txtDepartureDate = row.findViewById(R.id.rowDepartureDate);
            txtReturnDate = row.findViewById(R.id.rowReturnDate);
            txtPrice = row.findViewById(R.id.rowPrice);
            txtLocation = row.findViewById(R.id.rowLocation);
            img = row.findViewById(R.id.rowImageView);
        }
    }

    public void setClickListener(View.OnClickListener callback) {
        onClickListener = callback;
    }
}
