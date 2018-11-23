package pl.androidlist.androidlist.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import pl.androidlist.androidlist.Model.Wyjazd;
import pl.androidlist.androidlist.R;

/**
 * Created by Makarion on 2018-11-22.
 */

public class TripsListAdapter extends RecyclerView.Adapter<TripsListAdapter.ViewHolder> {

    private Context context;
    private List<Wyjazd> tripsList;

    public TripsListAdapter(Context context,List<Wyjazd> tripsList) {
        this.context = context;
        this.tripsList = tripsList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Wyjazd wyjazd = tripsList.get(position);

        viewHolder.txtDepartureDate.setText(wyjazd.getDataWyjazdu());
        viewHolder.txtReturnDate.setText(wyjazd.getDataPowrotu());
        viewHolder.txtPrice.setText(wyjazd.getCena());
        viewHolder.txtLocation.setText(wyjazd.getDataWyjazdu());

        byte [] recordImage = wyjazd.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(recordImage,0,recordImage.length);
        viewHolder.img.setImageBitmap(bitmap);
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
}
