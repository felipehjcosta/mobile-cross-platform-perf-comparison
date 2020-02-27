package com.example.android

import android.app.Application

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        RamUsageCollector()
    }
}