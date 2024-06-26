package main.teams.data.local

import main.teams.domain.model.Team
import main.teams.domain.model.TeamDriver


fun TeamEntity.mapToDomainModel(): Team {
    return Team(
        id = this.id,
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

fun Team.mapFromDomainModel(): TeamEntity {
    return TeamEntity(
        id = this.id,
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

fun List<TeamEntity>.mapToDomainModelList(): List<Team> {
    return this.map { it.mapToDomainModel() }
}

fun List<Team>.mapFromDomainModelList(): List<TeamEntity> {
    return this.map { it.mapFromDomainModel() }
}
