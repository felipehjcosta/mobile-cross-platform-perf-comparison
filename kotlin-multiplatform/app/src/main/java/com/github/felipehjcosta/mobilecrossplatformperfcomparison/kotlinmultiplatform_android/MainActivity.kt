package com.github.felipehjcosta.mobilecrossplatformperfcomparison.kotlinmultiplatform_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.github.felipehjcosta.mobilecrossplatformperfcomparison.kotlinmultiplatform.Timer

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val timer by lazy {
        findViewById<TextView>(R.id.timer)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timer().start {
            timer.text = it
        }
    }
}