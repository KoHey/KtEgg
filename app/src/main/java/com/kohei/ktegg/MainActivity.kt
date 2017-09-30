package com.kohei.ktegg

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity(), SensorEventListener {

    private val text1: TextView by lazy {
        findViewById(R.id.textView1) as TextView
    }
    private val text2: TextView by lazy {
        findViewById(R.id.textView2) as TextView
    }
    private val text3: TextView by lazy {
        findViewById(R.id.textView3) as TextView
    }

    var sensorManager: SensorManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super<AppCompatActivity>.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager?
        text1.text = "a"
        text2.text = "b"
        text3.text = "c"
    }

    override fun onResume() {
        super.onResume()
        sensorManager?.registerListener(this, sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_GAME)
        sensorManager?.registerListener(this, sensorManager?.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), SensorManager.SENSOR_DELAY_GAME)

    }

    override fun onPause() {
        super.onPause()
        sensorManager?.unregisterListener(this)

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.getType() == Sensor.TYPE_ACCELEROMETER) {
            text1.text = event.values[0].toString()
            text2.text = event.values[1].toString()
            text3.text = event.values[2].toString()
        }
    }

}
