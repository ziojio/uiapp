package demo;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.os.SystemClock;

import com.tencent.mmkv.MMKV;

import java.io.File;
import java.util.Date;

import androidx.annotation.NonNull;
import androidz.App;
import androidz.AppUtil;
import dagger.hilt.android.HiltAndroidApp;
import demo.database.room.AppDB;
import demo.database.room.entity.TrackLog;
import demo.log.FileLogTree;
import demo.log.LogUtil;
import demo.ui.ktx.AppCache;
import timber.log.Timber;

@HiltAndroidApp
public class UIApp extends Application {
    private static UIApp uiApp;
    AppDB appDB;

    public static UIApp getApp() {
        return uiApp;
    }

    public static AppDB getDB() {
        return uiApp.appDB;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        uiApp = this;
        long start = SystemClock.elapsedRealtime();
        if (AppUtil.isDebuggable(this)) {
            Timber.plant(new FileLogTree(new File(LogUtil.getLogDir(this), LogUtil.getLogFileName(new Date()))));
            Timber.plant(new Timber.DebugTree() {
                @Override
                protected void log(int priority, String tag, @NonNull String message, Throwable t) {
                    LogUtil.saveLog(new TrackLog(tag, message));
                    super.log(priority, tag, message, t);
                }
            });
        }
        Timber.d("onCreate " + this);
        MMKV.initialize(this);
        appDB = AppDB.create(this);
        long time = SystemClock.elapsedRealtime() - start;
        Timber.d("onCreate time " + time + "ms");
        AppCache.set("AAA", "aaa");
        String a = (String) AppCache.get("A");
        Timber.d("onCreate isDebuggable " + App.INSTANCE.isDebuggable());
    }

    public static boolean debuggable() {
        return (uiApp.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
    }
}

