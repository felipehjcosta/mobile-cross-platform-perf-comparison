package sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.github.felipehjcosta.mobilecrossplatformperfcomparison.kotlinmultiplatform.CountDown

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val timer by lazy {
        findViewById<TextView>(R.id.timer)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CountDown().start {
            timer.text = it
        }
    }
}