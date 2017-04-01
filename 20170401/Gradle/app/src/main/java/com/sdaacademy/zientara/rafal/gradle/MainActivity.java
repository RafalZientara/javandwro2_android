package com.sdaacademy.zientara.rafal.gradle;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.sdaacademy.zientara.rafal.gameengine.Engine;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.oval);

        imageView.setImageDrawable(drawable);

        logIfDebug();
        logIfRelease();


        new Engine().doWork();
    }

    private void logIfDebug() {
        if (BuildConfig.DEBUG)
            Log.i(TAG, "This log is visible in debug mode!");
    }


    private void logIfRelease() {
        if (BuildConfig.BUILD_TYPE.equals("release"))
            Log.i(TAG, "You are my favorite customer!");
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
