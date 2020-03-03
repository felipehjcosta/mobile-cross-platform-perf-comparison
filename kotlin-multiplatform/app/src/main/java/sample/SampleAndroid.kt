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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Sample().checkMe()
        findViewById<TextView>(R.id.main_text).text = hello()
    }
}