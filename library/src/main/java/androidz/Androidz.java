package androidz;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/**
 * Main
 */
public class Androidz {
    private static final Handler handler = new Handler(Looper.getMainLooper());
    private static boolean debuggable;

    private Androidz() {
    }

    public static void initialize(Context context) {
        App.attachApplication((Application) context.getApplicationContext());
        debuggable = isDebuggable();
        if (isDebuggable()) {
            ActivityStackManager.getInstance().register((Application) context);
        }
    }

    public static Application getApp() {
        return App.INSTANCE;
    }

    public static boolean isDebuggable() {
        return debuggable;
    }

    public static void setDebuggable(boolean debuggable) {
        Androidz.debuggable = debuggable;
    }

    public static Handler getHandler() {
        return handler;
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void setLogger(Logger logger) {
        Logger.Companion.setDefault(logger);
    }
}
