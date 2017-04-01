package com.sdaacademy.zientara.rafal.resourcesfun;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playSound(final View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
        final Animation animationDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.startAnimation(animationDown);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(animation);


        switch (view.getId()) {
            default:
            case R.id.button:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.frame_drum);
                break;

            case R.id.button2:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bass);
                break;

            case R.id.button4:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.gong);
                break;

        }

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

        if (mediaPlayer != null && mediaPlayer.isPlaying())
            mediaPlayer.stop();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        if (mp != null)
            mp.release();
    }
}
