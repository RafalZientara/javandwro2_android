package com.sdaacademy.zientara.rafal.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TESTY", "onCreate");

        TextView hello = (TextView) findViewById(R.id.helloText);
        hello.setText("Siemanko!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TESTY", "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TESTY", "onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TESTY", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TESTY", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TESTY", "onDestroy");
    }
}
