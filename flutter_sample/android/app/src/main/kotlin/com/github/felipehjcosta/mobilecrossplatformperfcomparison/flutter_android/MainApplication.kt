package com.github.felipehjcosta.mobilecrossplatformperfcomparison.flutter_android

import io.flutter.app.FlutterApplication

class MainApplication : FlutterApplication() {

    override fun onCreate() {
        super.onCreate()
        RamUsageCollector()
    }
}