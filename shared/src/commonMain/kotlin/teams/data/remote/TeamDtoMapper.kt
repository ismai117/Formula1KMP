package teams.data.remote

import main.teams.data.remote.TeamDto
import main.teams.domain.model.Team
import main.teams.domain.model.TeamDriver

fun TeamDto.mapToDomainModel(): Team {
    return Team(
        id = null,
        name = this.name,
        fullName = this.fullName,
        logoUrl = this.logoUrl,
        carImageUrl = this.carImageUrl,
        teamColour = this.teamColour,
        drivers = this.drivers.map { teamDriver ->
            TeamDriver(
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

fun List<TeamDto>.mapToDomainModelList(): List<Team> {
    return this.map { it.mapToDomainModel() }
}

