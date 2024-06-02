package database


import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.ncgroup.formula1kmp.AndroidApp
import database.AppDatabase


actual fun getAppDatabase(): AppDatabase {
    val dbFile = AndroidApp.INSTANCE.getDatabasePath(AppDatabase.DB_NAME)
    return Room.databaseBuilder<AppDatabase>(
        context = AndroidApp.INSTANCE.applicationContext,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}