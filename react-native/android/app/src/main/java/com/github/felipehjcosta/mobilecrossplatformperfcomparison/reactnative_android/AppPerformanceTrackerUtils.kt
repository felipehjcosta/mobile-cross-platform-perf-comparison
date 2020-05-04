package com.github.felipehjcosta.mobilecrossplatformperfcomparison.reactnative_android

import android.app.Application
import com.github.felipehjcosta.perf.PerformanceTracker
import com.github.felipehjcosta.perf.console.logging
import com.github.felipehjcosta.perf.firebase.firebaseDelivery
import com.github.felipehjcosta.perf.with
import com.google.firebase.analytics.FirebaseAnalytics


class AppPerformanceTrackerUtils {
    companion object {
        @JvmStatic
        fun initialize(application: Application) {
            PerformanceTracker.initialize() with {
                logging(true)
                firebaseDelivery(FirebaseAnalytics.getInstance(application))
            }
        }
    }
}
