package database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSHomeDirectory
import database.AppDatabase
import database.instantiateImpl

actual fun getAppDatabase(): AppDatabase {
    val dbFile = NSHomeDirectory() + "/${AppDatabase.DB_NAME}"
    return Room.databaseBuilder<AppDatabase>(
        name = dbFile,
        factory = { AppDatabase::class.instantiateImpl() }
    )
        .fallbackToDestructiveMigrationOnDowngrade(false)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}