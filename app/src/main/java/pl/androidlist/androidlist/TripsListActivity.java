package pl.androidlist.androidlist;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pl.androidlist.androidlist.Adapter.TripsListAdapter;
import pl.androidlist.androidlist.Model.Wyjazd;

public class TripsListActivity extends AppCompatActivity {

    RecyclerView TripsListRecyclerView;
    RecyclerView.Adapter adapter;


    List<Wyjazd> tripsList = new ArrayList<>();

    ImageView imageViewIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips_list);


        TripsListRecyclerView = findViewById(R.id.trips_recycler_view);
        TripsListRecyclerView.setHasFixedSize(true);
        TripsListRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new TripsListAdapter(this, tripsList);
        TripsListRecyclerView.setAdapter(adapter);



        //pobranie wycieczek z bazy danych

        final Cursor cursor = MainActivity.sqLiteHelper.getData("SELECT * FROM TRIPS");

        tripsList.clear();
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String departureDate = cursor.getString(1);
            String returnDate = cursor.getString(2);
            String price = cursor.getString(3);
            String location = cursor.getString(4);

            byte [] image = cursor.getBlob(5);

            tripsList.add(new Wyjazd(id, departureDate, returnDate, price, location, image));
            adapter.notifyDataSetChanged();

            if(tripsList.size()==0){
                Toast.makeText(this, "Brak wyjazdów", Toast.LENGTH_SHORT).show();
            }
        }

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT){

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
                removeTrip((int) viewHolder.itemView.getTag());
                Toast.makeText(TripsListActivity.this, "Usunięto wycieczkę", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(TripsListRecyclerView);
    }

    private void removeTrip(int tag) {
        MainActivity.sqLiteHelper.deleteData(tag);
    }
}
