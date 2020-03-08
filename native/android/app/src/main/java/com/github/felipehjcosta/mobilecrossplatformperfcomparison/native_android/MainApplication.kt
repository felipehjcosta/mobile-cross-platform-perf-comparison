package com.github.felipehjcosta.mobilecrossplatformperfcomparison.native_android

import android.app.Application

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        RamUsageCollector()
    }
}