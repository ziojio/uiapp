package androidz;

import android.util.Log;

import androidx.annotation.Nullable;

import static androidz.Androidz.isDebuggable;


public abstract class Logger {

    abstract void log(int priority, @Nullable String tag, @Nullable String msg, @Nullable Throwable tr);

    private static Logger DEFAULT = new Logger() {
        void log(int priority, @Nullable String tag, @Nullable String msg, @Nullable Throwable tr) {
            if (isDebuggable()) switch (priority) {
                case Log.VERBOSE -> Log.v(tag, msg, tr);
                case Log.DEBUG -> Log.d(tag, msg, tr);
                case Log.INFO -> Log.i(tag, msg, tr);
                case Log.WARN -> Log.w(tag, msg, tr);
                case Log.ERROR -> Log.e(tag, msg, tr);
                case Log.ASSERT -> Log.wtf(tag, msg, tr);
            }
        }
    };

    public static void setLogger(Logger logger) {
        Logger.DEFAULT = logger;
    }

    public static void v(@Nullable String tag, @Nullable String msg) {
        DEFAULT.log(Log.VERBOSE, tag, msg, null);
    }

    public static void v(@Nullable String tag, @Nullable String msg, @Nullable Throwable tr) {
        DEFAULT.log(Log.VERBOSE, tag, msg, tr);
    }

    public static void d(@Nullable String tag, @Nullable String msg) {
        DEFAULT.log(Log.DEBUG, tag, msg, null);
    }

    public static void d(@Nullable String tag, @Nullable String msg, @Nullable Throwable tr) {
        DEFAULT.log(Log.DEBUG, tag, msg, tr);
    }

    public static void i(@Nullable String tag, @Nullable String msg) {
        DEFAULT.log(Log.INFO, tag, msg, null);
    }

    public static void i(@Nullable String tag, @Nullable String msg, @Nullable Throwable tr) {
        DEFAULT.log(Log.INFO, tag, msg, tr);
    }

    public static void w(@Nullable String tag, @Nullable String msg) {
        DEFAULT.log(Log.WARN, tag, msg, null);
    }

    public static void w(@Nullable String tag, @Nullable String msg, @Nullable Throwable tr) {
        DEFAULT.log(Log.WARN, tag, msg, tr);
    }

    public static void e(@Nullable String tag, @Nullable String msg) {
        DEFAULT.log(Log.ERROR, tag, msg, null);
    }

    public static void e(@Nullable String tag, @Nullable String msg, @Nullable Throwable tr) {
        DEFAULT.log(Log.ERROR, tag, msg, tr);
    }

    public static void wtf(@Nullable String tag, @Nullable String msg) {
        DEFAULT.log(Log.ASSERT, tag, msg, null);
    }

    public static void wtf(@Nullable String tag, @Nullable String msg, @Nullable Throwable tr) {
        DEFAULT.log(Log.ASSERT, tag, msg, tr);
    }

}
