package androidz

import android.app.ActivityManager
import android.content.Context
import androidz.Androidz.getApp
import java.io.File

object CleanUtil {

    /**
     * Clean the internal cache.
     * directory: /data/data/package/cache
     */
    @JvmStatic
    fun cleanInternalCache(): Boolean {
        return FileUtil.deleteContents(getApp().cacheDir)
    }

    /**
     * Clean the internal files.
     * directory: /data/data/package/files
     */
    @JvmStatic
    fun cleanInternalFiles(): Boolean {
        return FileUtil.deleteContents(getApp().filesDir)
    }

    /**
     * Clean the internal shared preferences.
     * directory: /data/data/package/shared_prefs
     */
    @JvmStatic
    fun cleanInternalSp(): Boolean {
        return FileUtil.deleteContents(File(getApp().filesDir.parent, "shared_prefs"))
    }

    /**
     * Clean the internal databases.
     * directory: /data/data/package/databases
     */
    @JvmStatic
    fun cleanInternalDbs(): Boolean {
        return FileUtil.deleteContents(File(getApp().filesDir.parent, "databases"))
    }

    /**
     * Clean the internal database by name.
     * directory: /data/data/package/databases/dbName
     */
    @JvmStatic
    fun cleanInternalDb(dbName: String?): Boolean {
        return getApp().deleteDatabase(dbName)
    }

    /**
     * Clean the external file.
     * directory: /storage/emulated/0/android/data/package/file
     */
    @JvmStatic
    fun cleanExternalFile(): Boolean {
        val file = getApp().getExternalFilesDir(null)
        return file == null || FileUtil.deleteContents(file)
    }

    /**
     * Clean the external cache.
     * directory: /storage/emulated/0/android/data/package/cache
     */
    @JvmStatic
    fun cleanExternalCache(): Boolean {
        val file = getApp().externalCacheDir
        return file == null || FileUtil.deleteContents(file)
    }

    @JvmStatic
    fun cleanAppUserData() {
        val am = getApp().getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        am.clearApplicationUserData()
    }
}