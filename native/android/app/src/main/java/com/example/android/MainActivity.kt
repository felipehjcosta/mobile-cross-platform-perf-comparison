package com.example.android

import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val timer by lazy {
        findViewById<TextView>(R.id.timer)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initTimer()
    }

    private fun initTimer() {
        val startTime = SystemClock.elapsedRealtime()
        val handler = Handler()
        val runnable: Runnable = object : Runnable {
            override fun run() {
                val timeDifference = SystemClock.elapsedRealtime() - startTime
                val seconds = timeDifference / 1000L
                val minutes = seconds / 60L
                val leftoverSeconds = seconds % 60L
                val leftoverMillis = timeDifference % 1000L / 10L
                timer.text = String.format("%02d:%02d:%2d", minutes, leftoverSeconds, leftoverMillis)
                handler.postDelayed(this, 10L)
            }
        }

        handler.postDelayed(runnable, 1L)
    }
}