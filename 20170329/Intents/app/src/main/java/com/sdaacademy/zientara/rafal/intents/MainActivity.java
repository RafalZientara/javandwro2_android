package com.sdaacademy.zientara.rafal.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText myEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondActivity();
            }
        });

        myEditText = (EditText) findViewById(R.id.myText);

    }

    private void openSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("imie", myEditText.getText().toString());
        startActivity(intent);
    }
}
