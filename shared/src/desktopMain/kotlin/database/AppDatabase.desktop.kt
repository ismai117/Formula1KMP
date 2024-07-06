package database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import database.AppDatabase.Companion.DB_NAME
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import java.io.File


actual fun getAppDatabase(): AppDatabase {
    val dbFile = File(System.getProperty("java.io.tmpdir"), DB_NAME)
    return Room.databaseBuilder<AppDatabase>(
        name = dbFile.absolutePath
    )
        .fallbackToDestructiveMigrationOnDowngrade(false)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}