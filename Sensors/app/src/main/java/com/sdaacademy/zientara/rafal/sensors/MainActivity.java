package com.sdaacademy.zientara.rafal.sensors;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometerSensor;
    private View rootView;
    private float maxValue = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = findViewById(R.id.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (accelerometerSensor != null)
            sensorManager.registerListener((SensorEventListener) this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (accelerometerSensor != null)
            sensorManager.unregisterListener(this, accelerometerSensor);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor == accelerometerSensor || event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            Log.d("SENSOR", "x = " + x + "\t y = " + y + "\t z = " + z);
            Log.d("SENSOR String", String.format("x = %f \t y = %f \t z = %f", x, y, z));
            maxValue = Math.max(maxValue, Math.abs(x));
            maxValue = Math.max(maxValue, Math.abs(y));
            maxValue = Math.max(maxValue, Math.abs(z));
            x += maxValue;
            y += maxValue;
            z += maxValue;

            int r = (int) (255 * x / (maxValue * 2));
            int g = (int) (255 * y / (maxValue * 2));
            int b = (int) (255 * z / (maxValue * 2));

            int color = Color.rgb(r, g, b);
            rootView.setBackgroundColor(color);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
