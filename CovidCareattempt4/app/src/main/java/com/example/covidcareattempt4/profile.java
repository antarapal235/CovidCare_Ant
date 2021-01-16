package com.example.covidcareattempt4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity {

    TextView FirstName, LastName, Email, Vaccine;
    ImageView User_image, Email_image, Vaccine_image;
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private static final String USERS = "users";
    private String email;
    private String userid;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        FirstName = findViewById(R.id.firstname);
        LastName = findViewById(R.id.lastname);
        Email = findViewById(R.id.email_textview);
        Vaccine = findViewById(R.id.vaccine_textview);
        User_image = findViewById(R.id.user_image);
        Email_image = findViewById(R.id.email_imageview);
        Vaccine_image = findViewById(R.id.vaccine_imageview);

        Intent intent = getIntent();
        email = intent.getStringExtra("email");


        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = rootRef.child(USERS);
        Log.v("USERID", userRef.getKey());


        //Database still needs to be craeted!!!
        userRef.addValueEventListener(new ValueEventListener() {
            String fname, lname, mail, vaccinated;
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot keyId: dataSnapshot.getChildren()) {
                    if (keyId.child("email").getValue().equals(email)) {
                        fname = keyId.child("firstName").getValue(String.class);
                        lname = keyId.child("lastName").getValue(String.class);
                        vaccinated = keyId.child("vaccinated").getValue(String.class);
                        break;
                    }
                }
                FirstName.setText(fname);
                LastName.setText(lname);
                Email.setText(email);
                Vaccine.setText(vaccinated);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }
}