package com.sdaacademy.zientara.rafal.sandbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView firstText = (TextView) findViewById(R.id.first);
        TextView secondText = (TextView) findViewById(R.id.second);
    }
}
