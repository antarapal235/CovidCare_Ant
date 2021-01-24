package com.example.covidcareattempt4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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

    private ListView ListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ArrayList<String> list = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, list);

        ListView = (ListView) findViewById(R.id.listview);
        ListView.setAdapter(adapter);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("user").child("antarapal235").child("log");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    list.add(snapshot.getValue().toString());
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