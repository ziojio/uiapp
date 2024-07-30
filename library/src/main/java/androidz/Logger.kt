package androidz

import android.util.Log
import androidz.Androidz.isDebuggable


abstract class Logger {

    abstract fun log(priority: Int, tag: String, msg: String, tr: Throwable?)

    companion object {
        var default: Logger = object : Logger() {
            override fun log(priority: Int, tag: String, msg: String, tr: Throwable?) {
                if (!isDebuggable())
                    return
                when (priority) {
                    Log.VERBOSE -> Log.v(tag, msg, tr)
                    Log.DEBUG -> Log.d(tag, msg, tr)
                    Log.INFO -> Log.i(tag, msg, tr)
                    Log.WARN -> Log.w(tag, msg, tr)
                    Log.ERROR -> Log.e(tag, msg, tr)
                }
            }
        }

        @JvmOverloads
        @JvmStatic
        fun v(tag: String, msg: String, tr: Throwable? = null) {
            default.log(Log.VERBOSE, tag, msg, tr)
        }

        @JvmOverloads
        @JvmStatic
        fun d(tag: String, msg: String, tr: Throwable? = null) {
            default.log(Log.DEBUG, tag, msg, tr)
        }

        @JvmOverloads
        @JvmStatic
        fun i(tag: String, msg: String, tr: Throwable? = null) {
            default.log(Log.INFO, tag, msg, tr)
        }

        @JvmOverloads
        @JvmStatic
        fun w(tag: String, msg: String, tr: Throwable? = null) {
            default.log(Log.WARN, tag, msg, tr)
        }

        @JvmOverloads
        @JvmStatic
        fun e(tag: String, msg: String, tr: Throwable? = null) {
            default.log(Log.ERROR, tag, msg, tr)
        }
    }
}
