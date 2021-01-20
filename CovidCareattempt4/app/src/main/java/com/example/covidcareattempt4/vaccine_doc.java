package com.example.covidcareattempt4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class vaccine_doc extends AppCompatActivity {

    private Button mSyncButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_doc);

        mSyncButton = (Button)findViewById(R.id.button3);

        mSyncButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openDialog();
                    }
                }

        );
    }


    public void openDialog() {
        vaccine_popup poop = new vaccine_popup();
        poop.show(getSupportFragmentManager(), "example dialog");
    }
}