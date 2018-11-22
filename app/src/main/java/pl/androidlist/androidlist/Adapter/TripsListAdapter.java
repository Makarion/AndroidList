package pl.androidlist.androidlist.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import pl.androidlist.androidlist.Model.Wyjazd;

/**
 * Created by Makarion on 2018-11-22.
 */

public class TripsListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Wyjazd> tripsList;

    public TripsListAdapter(Context context, int layout, ArrayList<Wyjazd> tripsList) {
        this.context = context;
        this.layout = layout;
        this.tripsList = tripsList;
    }

    @Override
    public int getCount() {
        return tripsList.size();
    }

    @Override
    public Object getItem(int k) {
        return tripsList.get(k);
    }

    @Override
    public long getItemId(int k) {
        return k;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
