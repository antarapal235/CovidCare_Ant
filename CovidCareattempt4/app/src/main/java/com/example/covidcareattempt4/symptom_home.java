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
                        openDialog();
                    }
                }

        );
    }

    public void openDialog() {
        boolean isChecked1 = mcheckBox1.isChecked();
        boolean isChecked2 = mcheckBox2.isChecked();
        boolean isChecked3 = mcheckBox3.isChecked();
        boolean isChecked4 = mcheckBox4.isChecked();
        boolean isChecked5 = mcheckBox5.isChecked();
        boolean isChecked6 = mcheckBox6.isChecked();
        boolean isChecked7 = mcheckBox7.isChecked();
        boolean isChecked8 = mcheckBox8.isChecked();
        boolean isChecked9 = mcheckBox9.isChecked();
        if(isChecked1 || isChecked2 || isChecked3 || isChecked4 || isChecked5 || isChecked6 || isChecked7 || isChecked8 || isChecked9 ){
            popup_dialog_negative popDia = new popup_dialog_negative();
            popDia.show(getSupportFragmentManager(), "example dialog");
        }else{
            popup_dialog popDia2 = new popup_dialog();
            popDia2.show(getSupportFragmentManager(), "example dialog");
        }
    }

}