package com.example.covidcareattempt4;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class symptom_home extends AppCompatActivity {

    private CheckBox mcheckBox1, mcheckBox2, mcheckBox3, mcheckBox4, mcheckBox5, mcheckBox6, mcheckBox7, mcheckBox8, mcheckBox9;
    private Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_home);

        mcheckBox1 = (CheckBox)findViewById(R.id.checkBox1);
        mcheckBox2 = (CheckBox)findViewById(R.id.checkBox2);
        mcheckBox3 = (CheckBox)findViewById(R.id.checkBox3);
        mcheckBox4 = (CheckBox)findViewById(R.id.checkBox4);
        mcheckBox5 = (CheckBox)findViewById(R.id.checkBox5);
        mcheckBox6 = (CheckBox)findViewById(R.id.checkBox6);
        mcheckBox7 = (CheckBox)findViewById(R.id.checkBox7);
        mcheckBox8 = (CheckBox)findViewById(R.id.checkBox8);
        mcheckBox9 = (CheckBox)findViewById(R.id.checkBox9);
        mSubmitButton = (Button)findViewById(R.id.QuizButton);

        mSubmitButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        StringBuffer result = new StringBuffer();
                        result.append("checkBox1: ").append(mcheckBox1.isChecked());
                        result.append(" checkBox2: ").append(mcheckBox2.isChecked());
                        result.append(" checkBox3: ").append(mcheckBox3.isChecked());
                        result.append(" checkBox4: ").append(mcheckBox4.isChecked());
                        result.append(" checkBox5: ").append(mcheckBox5.isChecked());
                        result.append(" checkBox6: ").append(mcheckBox6.isChecked());
                        result.append(" checkBox7: ").append(mcheckBox7.isChecked());
                        result.append(" checkBox8: ").append(mcheckBox8.isChecked());
                        result.append(" checkBox9: ").append(mcheckBox9.isChecked());

                        Log.d("Debug", "onClick: pp");

                        Toast.makeText(symptom_home.this, result.toString(), Toast.LENGTH_LONG).show();
                    }
                }

        );
    }



}