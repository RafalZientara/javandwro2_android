package com.sdaacademy.zientara.rafal.rotateaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.moreButton)
    AppCompatButton moreButton;
    @BindView(R.id.inputText)
    TextView inputText;
    @BindView(R.id.numberText)
    TextView numberText;

    private int clickCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        refreshUi();
    }

    @OnClick(R.id.moreButton)
    public void addNumber() {
        clickCount++;
        refreshUi();
    }

    private void refreshUi() {
        numberText.setText(Integer.toString(clickCount));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(getClass().getSimpleName(), "onSaveInstanceState");
        outState.putInt("my awesome clicks", clickCount);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        clickCount = savedInstanceState.getInt("my awesome clicks");
        refreshUi();
    }
}
