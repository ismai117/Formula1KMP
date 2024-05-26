package database

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import main.teams.data.local.TeamDriverEntity


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