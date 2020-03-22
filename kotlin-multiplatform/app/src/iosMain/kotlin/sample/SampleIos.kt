package sample

import platform.Foundation.NSString
import platform.Foundation.create

actual class Sample {
    actual fun checkMe() = 7
}

actual object Platform {
    actual val name: String = "iOS"
}

actual fun formatString(source: String, minutes: Long, seconds: Long, millis: Long): String {
    return NSString.create(format = source, args = *arrayOf(minutes, seconds, millis)) as String
}