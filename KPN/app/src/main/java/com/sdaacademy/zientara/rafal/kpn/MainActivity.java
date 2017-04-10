package com.sdaacademy.zientara.rafal.kpn;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Drawable cutDrawable;
    private Drawable paperDrawable;
    private Drawable stoneDrawable;

    private ImageView myAction;
    private ImageView computerAction;
    private Action myActionEnum;
    private Action computerActionEnum;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random();

        cutDrawable = ContextCompat.getDrawable(this, R.drawable.ic_content_cut_black_24dp);
        paperDrawable = ContextCompat.getDrawable(this, R.drawable.ic_content_copy_black_24dp);
        stoneDrawable = ContextCompat.getDrawable(this, R.drawable.ic_brightness_1_black_24dp);

        myAction = (ImageView) findViewById(R.id.myActionImage);
        computerAction = (ImageView) findViewById(R.id.computerActionImage);
    }

    public void myClick(View view) {
        switch (view.getId()) {
            case R.id.cutButton:
                myAction.setImageDrawable(cutDrawable);
                myActionEnum = Action.CUT;
                break;
            case R.id.paperButton:
                myAction.setImageDrawable(paperDrawable);
                myActionEnum = Action.PAPER;
                break;
            case R.id.stoneButton:
                myAction.setImageDrawable(stoneDrawable);
                myActionEnum = Action.STONE;
                break;
        }

        computerActionEnum = getRandomAction();
    }

    private Action getRandomAction() {
        int randomAction = random.nextInt(3);
        if(randomAction == 0)
            return Action.STONE;
        if(randomAction == 1)
            return Action.PAPER;
        return Action.CUT;
    }

    enum Action {
        STONE,
        PAPER,
        CUT;
    }

}
