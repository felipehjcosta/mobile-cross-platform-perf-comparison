package com.github.felipehjcosta.mobilecrossplatformperfcomparison.kotlinmultiplatform

actual fun formatString(source: String, minutes: Long, seconds: Long, millis: Long): String {
    return String.format(source, minutes, seconds, millis)
}