package sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

actual class Sample {
    actual fun checkMe() = 44
}

actual object Platform {
    actual val name: String = "Android"
}

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val timer by lazy {
        findViewById<TextView>(R.id.timer)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        countDown {
            timer.text = it
        }
    }
}

actual fun formatString(source: String, minutes: Long, seconds: Long, millis: Long): String {
    return String.format(source, minutes, seconds, millis)
}