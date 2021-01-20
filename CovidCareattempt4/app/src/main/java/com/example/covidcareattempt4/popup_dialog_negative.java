package com.example.covidcareattempt4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Dialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class popup_dialog_negative extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("ALERT: You have indicated the presence of symptoms of Covid-19. ")
                .setMessage("If you are feeling unwell and believe it is an emergency please dial 911 below. Alternatively, press OK to return to the Dashboard")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        }).setNegativeButton("Dial 911", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        return builder.create();
    }
}
