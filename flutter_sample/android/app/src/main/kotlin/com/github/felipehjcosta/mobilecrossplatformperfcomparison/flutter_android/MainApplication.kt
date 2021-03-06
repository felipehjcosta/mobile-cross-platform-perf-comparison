package com.github.felipehjcosta.mobilecrossplatformperfcomparison.flutter_android

import io.flutter.app.FlutterApplication
import com.github.felipehjcosta.perf.PerformanceTracker
import com.github.felipehjcosta.perf.console.logging
import com.github.felipehjcosta.perf.firebase.firebaseDelivery
import com.github.felipehjcosta.perf.with
import com.google.firebase.analytics.FirebaseAnalytics

class MainApplication : FlutterApplication() {

    override fun onCreate() {
        super.onCreate()
        PerformanceTracker.initialize() with {
            logging(true)
            firebaseDelivery(FirebaseAnalytics.getInstance(this@MainApplication))
        }
    }
}