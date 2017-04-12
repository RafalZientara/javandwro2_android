package com.sdaacademy.zientara.rafal.rotatelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;

    @BindView(R.id.versionsListView)
    ListView versionsListView;

    private String[] androidVersionsArray;
    private ListAdapter listAdapter;
    private Random random;
    private ArrayList<String> randomVersions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        androidVersionsArray = getResources().getStringArray(R.array.wersje_androida);

        random = new Random();
        randomVersions = new ArrayList<>();

        //listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, randomVersions);
        //versionsListView.setAdapter(listAdapter);
    }

    @OnClick(R.id.button)
    public void addRandomVersionToList() {
        randomVersions.add(getRandomString());
        refreshList();
    }

    private void refreshList() {
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, randomVersions);
        versionsListView.setAdapter(listAdapter);
    }

    private String getRandomString() {
        int randomIndex = random.nextInt(androidVersionsArray.length);
        return androidVersionsArray[randomIndex];
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("randoms", randomVersions);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        randomVersions = savedInstanceState.getStringArrayList("randoms");
        if (randomVersions == null)
            randomVersions = new ArrayList<>();

        refreshList();
    }
}
