package com.sdaacademy.zientara.rafal.layouts;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements AlertDialog.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
    }

    public void registerClick(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Title")
                .setMessage("Message blah blah")
                //.setIcon(R.drawable.graphic)
                .setNegativeButton("Cancel", null)
                .setPositiveButton("OK", this)
                .setCancelable(false)
                .create();

        alertDialog.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        finish();
    }
}
