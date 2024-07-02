package org.ncgroup.formula1kmp.main.teams.data.local

import app.cash.sqldelight.coroutines.asFlow
import com.ncgroup.formula1kmp.db.TeamEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import org.ncgroup.formula1kmp.db.AppDatabase
import org.ncgroup.formula1kmp.main.teams.domain.model.Team
import org.ncgroup.formula1kmp.main.teams.domain.model.TeamDriver

class TeamsLocalService(
    private val db: AppDatabase
) {

    private val queries = db.teamEntityQueries

    suspend fun selectTeams(): Flow<List<Team>> = flow {
        val teams = queries.selectTeams().executeAsList()
        val teamDrivers = teams.map { teamEntity ->
            val drivers = queries.selectDriversByTeamName(teamEntity.name).executeAsList()
            teamEntity.mapToDomainModel(drivers)
        }
        emit(teamDrivers)
    }

    suspend fun selectTeamByName(name: String): Team {
        val team = queries.selectTeamByTeamName(name).executeAsOne()
        val teamDrivers = queries.selectDriversByTeamName(name).executeAsList()
        return team.mapToDomainModel(teamDrivers)
    }


    suspend fun insertTeam(teams: List<Team>) {
        teams.forEach { team ->
            queries.insertTeam(
                name = team.name,
                fullName = team.fullName,
                logoUrl = team.logoUrl,
                carImageUrl = team.carImageUrl,
                teamColour = team.teamColour,
                base = team.base,
                chassis = team.chassis,
                fastestLaps = team.fastestLaps.toLong(),
                firstTeamEntry = team.firstTeamEntry.toLong(),
                highestRaceFinish = team.highestRaceFinish,
                polePositions = team.polePositions.toLong(),
                powerUnit = team.powerUnit,
                teamChief = team.teamChief,
                technicalChief = team.technicalChief,
                worldChampionships = team.worldChampionships.toLong()
            )
            team.drivers.forEach { driver ->
                queries.insertTeamDriver(
                    driverNumber = driver.driverNumber.toLong(),
                    fullName = driver.fullName,
                    profileImageUrl = driver.profileImageUrl,
                    teamName = team.name
                )
            }
        }
    }

}