package com.github.felipehjcosta.mobilecrossplatformperfcomparison.kotlinmultiplatform

import platform.Foundation.NSString
import platform.Foundation.create

actual fun formatString(source: String, minutes: Long, seconds: Long, millis: Long): String {
    return NSString.create(format = source, args = *arrayOf(minutes, seconds, millis)) as String
}