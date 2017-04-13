package com.sdaacademy.zientara.rafal.miziator.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.sdaacademy.zientara.rafal.miziator.R;

/**
 * Created by Evil on 13.04.2017.
 */

public class MiziView extends View implements View.OnTouchListener {

    public static final String MIZI_MIZI = "Mizi-Mizi";
    private int radius;
    private Paint paint;
    float x;
    float y;
    private Point startPoint;

    public MiziView(Context context) {
        super(context);
        init(context);
    }

    public MiziView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MiziView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MiziView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        radius = context.getResources().getDimensionPixelSize(R.dimen.point_size);

        paint = new Paint();
        paint.setColor(ContextCompat.getColor(context, R.color.colorPrimary));
        paint.setAntiAlias(true);
        paint.setStrokeWidth(radius);

        setOnTouchListener(this);
        startPoint = new Point();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawARGB(120, 255, 0, 0);
        canvas.drawCircle(x, y, radius, paint);
        canvas.drawCircle(startPoint.x, startPoint.y, radius, paint);
        canvas.drawLine(startPoint.x, startPoint.y, x, y, paint);

        Object object = new Object();


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();
        //Log.d(MIZI_MIZI, "x = " + x + " \t y = " + y);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startPoint.x = (int) x;
                startPoint.y = (int) y;

                Log.d(MIZI_MIZI, "ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(MIZI_MIZI, "ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(MIZI_MIZI, "ACTION_UP");
                break;
        }

        invalidate();
        return true;
    }
}
