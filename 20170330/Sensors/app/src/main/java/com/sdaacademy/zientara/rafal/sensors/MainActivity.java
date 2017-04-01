package com.sdaacademy.zientara.rafal.sensors;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometerSensor;
    private float maxValue = 30;



    @BindView(R.id.rootViewId)
    View rootView;

    @BindView(R.id.gyroscopeText)
    TextView gyroscopeText;

    @BindView(R.id.fingerprintText)
    TextView fingerprintText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        int color = ContextCompat.getColor(this, R.color.colorAccent);
        //ContextCompat.getDrawable(this, R.drawable.picture)

        //wpieramy nowe funkcjonalnosci
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Toast.makeText(this, "Ale masz super telefon! :D", Toast.LENGTH_SHORT).show();
        }

        checkGyroscope();
    }

    private void checkGyroscope() {
        Sensor gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if(gyroscopeSensor != null)
            gyroscopeText.setText("You have gyroscope! :D");
        else
            gyroscopeText.setText("You don't have gyroscope! :(");

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
