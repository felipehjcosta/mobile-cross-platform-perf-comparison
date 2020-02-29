package com.example.flutter_sample

import io.flutter.app.FlutterApplication

class MainApplication : FlutterApplication() {

    override fun onCreate() {
        super.onCreate()
        RamUsageCollector()
    }
}