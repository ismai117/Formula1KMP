package teams.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "teams_table")
data class TeamEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val name: String,
    val fullName: String,
    val logoUrl: String,
    val carImageUrl: String,
    val teamColour: String,
    val drivers: List<TeamDriverEntity>,
    val base: String,
    val chassis: String,
    val fastestLaps: Int,
    val firstTeamEntry: Int,
    val highestRaceFinish: String,
    val polePositions: Int,
    val powerUnit: String,
    val teamChief: String,
    val technicalChief: String,
    val worldChampionships: Int
)

@Serializable
data class TeamDriverEntity(
    val driverNumber: Int,
    val fullName: String,
    val profileImageUrl: String
)