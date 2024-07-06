package database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import drivers.data.local.DriverEntity
import drivers.data.local.DriversDao
import teams.data.local.TeamEntity
import teams.data.local.TeamsDao
import teams.data.local.TeamDriverEntity


@Database(
    entities = [
        DriverEntity::class,
        TeamEntity::class
    ],
    version = 1
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

class TeamDriverEntityConverter {

    private val json = Json

    @TypeConverter
    fun fromObject(teamDriverEntity: List<TeamDriverEntity>?): String? {
        return teamDriverEntity?.let { json.encodeToString(it) }
    }

    @TypeConverter
    fun toObject(jsonString: String?): List<TeamDriverEntity>? {
        return jsonString?.let { json.decodeFromString<List<TeamDriverEntity>>(it) }
    }

}