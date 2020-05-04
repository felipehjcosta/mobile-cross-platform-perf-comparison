package com.github.felipehjcosta.mobilecrossplatformperfcomparison.native_android

import android.app.Application
import com.github.felipehjcosta.perf.PerformanceTracker
import com.github.felipehjcosta.perf.console.logging
import com.github.felipehjcosta.perf.firebase.firebaseDelivery
import com.github.felipehjcosta.perf.with
import com.google.firebase.analytics.FirebaseAnalytics

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        PerformanceTracker.initialize() with {
            logging(BuildConfig.DEBUG)
            firebaseDelivery(FirebaseAnalytics.getInstance(this@MainApplication))
        }
    }
}