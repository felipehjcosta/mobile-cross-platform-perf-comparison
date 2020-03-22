package com.github.felipehjcosta.mobilecrossplatformperfcomparison.kotlinmultiplatform

import com.soywiz.klock.DateTime
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CountDown {
    fun start(block: (String) -> Unit) {
        GlobalScope.launch(Dispatchers.Main) {
            val startTime = DateTime.nowUnixLong()
            while (true) {
                val timeDifference = DateTime.nowUnixLong() - startTime
                val seconds = timeDifference / 1000L
                val minutes = seconds / 60L
                val leftoverSeconds = seconds % 60L
                val leftoverMillis = timeDifference % 1000L / 10L
                block(formatString("%02d:%02d:%02d", minutes, leftoverSeconds, leftoverMillis))
                delay(1L)
            }
        }
    }
}