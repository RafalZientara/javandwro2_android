package com.sdaacademy.zientara.rafal.resourcesfun;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playSound(View view) {
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.frame_drum);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.start();
    }

    @Override
    protected void onResume() {
        super.onResume();

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.frame_drum);
        mediaPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if(mediaPlayer!=null && mediaPlayer.isPlaying())
            mediaPlayer.stop();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.release();
    }
}
