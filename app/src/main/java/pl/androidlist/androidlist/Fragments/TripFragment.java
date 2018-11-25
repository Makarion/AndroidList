package pl.androidlist.androidlist.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pl.androidlist.androidlist.Adapter.TripsListAdapter;
import pl.androidlist.androidlist.Model.Wyjazd;
import pl.androidlist.androidlist.R;


public class TripFragment extends Fragment {

    View v;
    private RecyclerView recyclerView;
    private List<Wyjazd> tripsList = new ArrayList<>();

    public TripFragment(){

    }

    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        v = layoutInflater.inflate(R.layout.row, container, false);
        recyclerView = v.findViewById(R.id.trips_recycler_view);

        TripsListAdapter tripsListAdapter = new TripsListAdapter(getActivity(), tripsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(tripsListAdapter);
        return v;

    }

}
