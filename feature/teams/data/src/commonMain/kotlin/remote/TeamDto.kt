package remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import teams.Team
import teams.TeamDriver

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
){
    fun toTeam(): Team {
        return Team(
            id = null,
            name = name,
            fullName = fullName,
            logoUrl = logoUrl,
            carImageUrl = carImageUrl,
            teamColour = teamColour,
            drivers = drivers.map { teamDriver ->
                TeamDriver(
                    fullName = teamDriver.fullName,
                    driverNumber = teamDriver.driverNumber,
                    profileImageUrl = teamDriver.profileImageUrl
                )
            },
            base = base,
            chassis = chassis,
            fastestLaps = fastestLaps,
            firstTeamEntry = firstTeamEntry,
            highestRaceFinish = highestRaceFinish,
            polePositions = polePositions,
            powerUnit = powerUnit,
            teamChief = teamChief,
            technicalChief = technicalChief,
            worldChampionships = worldChampionships
        )
    }
}

@Serializable
data class TeamDriverDto(
    @SerialName("driverNumber")
    val driverNumber: Int,
    @SerialName("fullName")
    val fullName: String,
    @SerialName("profileImageUrl")
    val profileImageUrl: String
)