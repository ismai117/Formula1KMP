package database

import androidx.room.Database
import androidx.room.RoomDatabase
import main.drivers.data.local.DriverEntity
import main.drivers.data.local.DriversDao


@Database(
    entities = [
        DriverEntity::class
    ],
    version = 2
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun driversDao(): DriversDao
    companion object {
        const val DB_NAME = "formula1.db"
    }
}

expect fun getAppDatabase(): AppDatabase