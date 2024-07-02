package org.ncgroup.formula1kmp.main.teams.data.local

import com.ncgroup.formula1kmp.db.TeamDriverEntity
import com.ncgroup.formula1kmp.db.TeamEntity
import org.ncgroup.formula1kmp.main.teams.domain.model.Team
import org.ncgroup.formula1kmp.main.teams.domain.model.TeamDriver


fun TeamEntity.mapToDomainModel(drivers: List<TeamDriverEntity>): Team {
    return Team(
        name = this.name,
        fullName = this.fullName,
        logoUrl = this.logoUrl,
        carImageUrl = this.carImageUrl,
        teamColour = this.teamColour,
        drivers = drivers.map { it.mapToDomainModel() },
        base = this.base,
        chassis = this.chassis,
        fastestLaps = this.fastestLaps.toInt(),
        firstTeamEntry = this.firstTeamEntry.toInt(),
        highestRaceFinish = this.highestRaceFinish,
        polePositions = this.polePositions.toInt(),
        powerUnit = this.powerUnit,
        teamChief = this.teamChief,
        technicalChief = this.technicalChief,
        worldChampionships = this.worldChampionships.toInt()
    )
}

fun TeamDriverEntity.mapToDomainModel(): TeamDriver {
    return TeamDriver(
        driverNumber = this.driverNumber.toInt(),
        fullName = this.fullName,
        profileImageUrl = this.profileImageUrl
    )
}


fun List<TeamEntity>.mapToDomainModelList(
    drivers: List<TeamDriverEntity>
): List<Team> {
    return this.map { it.mapToDomainModel(drivers) }
}