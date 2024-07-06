package database


import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import applicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO


actual fun getAppDatabase(): AppDatabase {
    val dbFile = applicationContext.getDatabasePath(AppDatabase.DB_NAME)
    return Room.databaseBuilder<AppDatabase>(
        context = applicationContext.applicationContext,
        name = dbFile.absolutePath
    )
        .fallbackToDestructiveMigrationOnDowngrade(false)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}