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
    version = 5
)
@TypeConverters(
    TeamDriverEntityConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun driversDao(): DriversDao
    abstract fun teamsDao(): TeamsDao

    companion object {
        const val DB_NAME = "formula1.db"
    }
}

expect fun getAppDatabase(): AppDatabase