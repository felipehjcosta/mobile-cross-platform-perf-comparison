package sample

import com.soywiz.klock.DateTime
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

expect class Sample() {
    fun checkMe(): Int
}

expect object Platform {
    val name: String
}

fun hello(): String = "Hello from ${Platform.name}"

class Proxy {
    fun proxyHello() = hello()
    fun proxyCountDown(block: (String) -> Unit) = countDown(block)
}

fun main() {
    println(hello())
}

fun countDown(block: (String) -> Unit) {
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

expect fun formatString(source: String, minutes: Long, seconds: Long, millis: Long): String
