package com.sdaacademy.zientara.rafal.playerpro;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer dupstep;
    private ImageView playButtonView;
    private ImageView pauseButtonView;
    private ImageView rewindButtonView;
    private SeekBar seekBarView;
    private SeekBar volumeSeekBarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButtonView = (ImageView) findViewById(R.id.playButton);
        pauseButtonView = (ImageView) findViewById(R.id.pauseButton);
        rewindButtonView = (ImageView) findViewById(R.id.rewindButton);
        seekBarView = (SeekBar) findViewById(R.id.seekBar);
        volumeSeekBarView = (SeekBar) findViewById(R.id.volumeSeekBar);

        dupstep = MediaPlayer.create(this, R.raw.bensound_dubstep);

        seekBarView.setMax(100);
        pauseButtonView.setVisibility(View.INVISIBLE);
        seekBarView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                float progress = seekBar.getProgress();
                int maxValue = 100;
                float currentProgress = progress / maxValue;
                int durationMillis = dupstep.getDuration();
                dupstep.seekTo((int) (durationMillis * currentProgress));
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.playButton:
                if (!dupstep.isPlaying())
                    dupstep.start();
                playButtonView.setVisibility(View.INVISIBLE);
                pauseButtonView.setVisibility(View.VISIBLE);
                break;

            case R.id.pauseButton:
                if (dupstep.isPlaying())
                    dupstep.pause();
                playButtonView.setVisibility(View.VISIBLE);
                pauseButtonView.setVisibility(View.INVISIBLE);
                break;

            case R.id.rewindButton:
                dupstep.seekTo(0);
                break;
        }
    }
}
