package com.example.androidsensorsalfz;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewMagnetic,textViewTemperature, textViewProximity,
            textViewPressure, textViewLight, textViewHumidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewHumidity = findViewById(R.id.textViewHumidity);
        textViewLight = findViewById(R.id.textViewLight);
        textViewMagnetic = findViewById(R.id.textViewMagneticField);
        textViewPressure = findViewById(R.id.textViewPressure);
        textViewTemperature = findViewById(R.id.textViewTemperature);
        textViewProximity = findViewById(R.id.textViewProximity);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        Sensor sensorHumidity = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        Sensor sensorLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        Sensor sensorMagnetic = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED);
        Sensor sensorPressure = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        Sensor sensorTemperature = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        Sensor sensorProximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);


        SensorEventListener sensorEventListenerHumidity = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                textViewHumidity.setText("Humidity  = " + sensorEvent.values[0]);
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };

        SensorEventListener sensorEventListenerLight = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                textViewLight.setText("Light  = " + sensorEvent.values[0]);
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };

        SensorEventListener sensorEventListenerPressure = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                textViewPressure.setText("Pressure  = " + sensorEvent.values[0]);
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };

        SensorEventListener sensorEventListenerMagnetic = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                textViewMagnetic.setText("Magnetic  = " + sensorEvent.values[0]);
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };

        SensorEventListener sensorEventListenerProximity = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                textViewProximity.setText("Proximity  = " + sensorEvent.values[0]);
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };

        SensorEventListener sensorEventListenerTemperature = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                textViewTemperature.setText("Ambient Temperature  = " + sensorEvent.values[0]);
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };

        sensorManager.registerListener(sensorEventListenerHumidity, sensorHumidity, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(sensorEventListenerLight, sensorLight, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(sensorEventListenerPressure, sensorPressure, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(sensorEventListenerProximity, sensorProximity, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(sensorEventListenerMagnetic, sensorMagnetic, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(sensorEventListenerTemperature, sensorTemperature, SensorManager.SENSOR_DELAY_NORMAL);
    }
}