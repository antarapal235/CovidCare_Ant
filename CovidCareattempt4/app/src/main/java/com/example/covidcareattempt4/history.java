package com.example.covidcareattempt4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class history extends AppCompatActivity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ArrayList<String> locations = new ArrayList<String>();
        ArrayList<String> dates = new ArrayList<String>();
        ArrayList<Boolean> checked = new ArrayList<Boolean>();

        ArchiveAdapterView adapter = new ArchiveAdapterView(this, locations, dates, checked);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, list);

        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("user").child("antarapal235").child("log");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                locations.clear();
                dates.clear();
                checked.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String date = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date (Integer.parseInt(snapshot.getKey())*1000));

//                    list.add(snapshot.getValue().toString() + ": " + snapshot.getKey());
                    dates.add(date);
                    for (DataSnapshot snapshot1 : snapshot.getChildren())
                    {
                        if (snapshot1.getKey().equals("loc")) locations.add(snapshot1.getValue().toString());
                        else if (snapshot1.getKey().equals("out"))
                        {
                            if(snapshot1.getValue().toString() == "true") checked.add(true);
                            else checked.add(false);
                        }
                    }
                    Log.d("children", snapshot.getValue().toString());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}