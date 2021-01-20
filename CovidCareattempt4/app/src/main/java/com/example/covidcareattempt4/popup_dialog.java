package com.example.covidcareattempt4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Dialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class popup_dialog extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("You do not have any symptoms!")
                .setMessage("Press OK to return to the Dashboard").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

            }
        });

        return builder.create();
    }

}
