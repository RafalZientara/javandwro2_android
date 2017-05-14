package com.sdaacademy.zientara.rafal.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferencesExample();
        getMultiPreferencesExample();

        try {
            FileOutputStream fileOutputStream = openFileOutput("plik.txt", Context.MODE_PRIVATE);
            fileOutputStream.write("hello".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void sharedPreferencesExample() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        preferences
                .edit()
                .putString("KLUCZ_ZMIENNEJ", "wpisuje wartosc zmiennej")
                .commit();

        String myVariable = preferences.getString("KLUCZ_ZMIENNEJ", "wartosc domyslna");
    }

    private void getMultiPreferencesExample() {
        SharedPreferences preferences1 = getSharedPreferences("preferencje1", MODE_PRIVATE);
        SharedPreferences preferences2 = getSharedPreferences("preferencje2", MODE_PRIVATE);
    }
}
