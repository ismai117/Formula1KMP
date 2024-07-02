package main.teams.data.remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TeamDto(
    @SerialName("base")
    val base: String,
    @SerialName("carImageUrl")
    val carImageUrl: String,
    @SerialName("chassis")
    val chassis: String,
    @SerialName("drivers")
    val drivers: List<TeamDriverDto>,
    @SerialName("fastestLaps")
    val fastestLaps: Int,
    @SerialName("firstTeamEntry")
    val firstTeamEntry: Int,
    @SerialName("fullName")
    val fullName: String,
    @SerialName("highestRaceFinish")
    val highestRaceFinish: String,
    @SerialName("logoUrl")
    val logoUrl: String,
    @SerialName("name")
    val name: String,
    @SerialName("polePositions")
    val polePositions: Int,
    @SerialName("powerUnit")
    val powerUnit: String,
    @SerialName("teamChief")
    val teamChief: String,
    @SerialName("technicalChief")
    val technicalChief: String,
    @SerialName("worldChampionships")
    val worldChampionships: Int,
    @SerialName("teamColour")
    val teamColour: String
)

@Serializable
data class TeamDriverDto(
    @SerialName("driverNumber")
    val driverNumber: Int,
    @SerialName("fullName")
    val fullName: String,
    @SerialName("profileImageUrl")
    val profileImageUrl: String
)