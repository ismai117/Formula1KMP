package database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import main.drivers.data.local.DriverEntity
import main.drivers.data.local.DriversDao
import main.teams.data.local.TeamEntity
import main.teams.data.local.TeamsDao


@Database(
    entities = [
        DriverEntity::class,
        TeamEntity::class
    ],
    version = 6
)
@TypeConverters(
    TeamDriverEntityConverter::class
)
abstract class AppDatabase : RoomDatabase(), DB {
    abstract fun driversDao(): DriversDao
    abstract fun teamsDao(): TeamsDao

    override fun clearAllTables() {
        super.clearAllTables()
    }

    companion object {
        const val DB_NAME = "formula1.db"
    }
}

expect fun getAppDatabase(): AppDatabase

// FIXME: Added a hack to resolve below issue:
// Class 'AppDatabase_Impl' is not abstract and does not implement abstract base class member 'clearAllTables'.
interface DB {
    fun clearAllTables(): Unit {}
}