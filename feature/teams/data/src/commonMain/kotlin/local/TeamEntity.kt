package local

import kotlinx.serialization.Serializable
import teams.Team
import teams.TeamDriver

@Serializable
data class TeamEntity(
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
){
    companion object{
        fun Team.fromTeam(): TeamEntity {
            return TeamEntity(
                name = this.name,
                fullName = this.fullName,
                logoUrl = this.logoUrl,
                carImageUrl = this.carImageUrl,
                teamColour = this.teamColour,
                drivers = this.drivers.map { teamDriver ->
                    TeamDriverEntity(
                        fullName = teamDriver.fullName,
                        driverNumber = teamDriver.driverNumber,
                        profileImageUrl = teamDriver.profileImageUrl
                    )
                },
                base = this.base,
                chassis = this.chassis,
                fastestLaps = this.fastestLaps,
                firstTeamEntry = this.firstTeamEntry,
                highestRaceFinish = this.highestRaceFinish,
                polePositions = this.polePositions,
                powerUnit = this.powerUnit,
                teamChief = this.teamChief,
                technicalChief = this.technicalChief,
                worldChampionships = this.worldChampionships
            )
        }
    }
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
            technicalChief =technicalChief,
            worldChampionships = worldChampionships
        )
    }
}

@Serializable
data class TeamDriverEntity(
    val driverNumber: Int,
    val fullName: String,
    val profileImageUrl: String
)