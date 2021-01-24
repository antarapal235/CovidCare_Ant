package com.example.covidcareattempt4;
import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArchiveAdapterView extends ArrayAdapter<String> {

    private final Activity context;
    private ArrayList<String> locations;
    private ArrayList<String> dates;
    private ArrayList<Boolean> checked;

    public ArchiveAdapterView(Activity context, ArrayList<String> locations,ArrayList<String> dates, ArrayList<Boolean> checked) {
        super(context, R.layout.mylist, locations);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.locations = locations;
        this.dates = dates;
        this.checked = checked;

    }

//    public void addLocation(String location)
//    {
//        locations.add(location);
//    }
//
//    public void addDate(String date)
//    {
//        dates.add(date);
//    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.subtitle);

        titleText.setText(locations.get(position));
        if (checked.get(position)) imageView.setImageResource(R.drawable.checked_out);
        else imageView.setImageResource(R.drawable.checked_in);
        subtitleText.setText(dates.get(position));

        return rowView;

    }
}