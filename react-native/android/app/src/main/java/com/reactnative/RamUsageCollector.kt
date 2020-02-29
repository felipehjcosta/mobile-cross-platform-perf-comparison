package com.reactnative;

import android.os.*

private val collectRAMUsage = {
    val memInfo = Debug.MemoryInfo()
    Debug.getMemoryInfo(memInfo)
    var totalMemoryOfCurrentAppProcess = memInfo.totalPrivateDirty.toLong()

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        totalMemoryOfCurrentAppProcess += memInfo.totalPrivateClean.toLong()
    }

    android.util.Log.i(
            "RamUsage",
            "Total memory of the current process in ${totalMemoryOfCurrentAppProcess / 1024L} MB"
    )
}

private val backgroundHandlerThread = HandlerThread(
        "BackgroundHandlerThread",
        Process.THREAD_PRIORITY_BACKGROUND
).apply { start() }

private val backgroundHandler = Handler(backgroundHandlerThread.looper).apply {
    post(object : Runnable {
        override fun run() {
            collectRAMUsage()
            postDelayed(this, 1000L)
        }
    })
}

class RamUsageCollector {
    companion object {
        init {
            backgroundHandler
        }
    }
}

