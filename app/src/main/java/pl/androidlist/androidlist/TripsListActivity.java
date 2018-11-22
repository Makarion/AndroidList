package pl.androidlist.androidlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

public class TripsListActivity extends AppCompatActivity {

    RecyclerView TripsListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips_list);

        TripsListView.findViewById(R.id.tripsRecyclerView);


    }
}
