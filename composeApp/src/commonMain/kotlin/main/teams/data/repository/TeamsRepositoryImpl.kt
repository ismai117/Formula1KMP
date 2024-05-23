package main.teams.data.repository

import main.drivers.data.local.DriversLocalService
import main.teams.domain.model.Team
import main.teams.domain.model.TeamDriver
import main.teams.domain.repository.TeamsRepository

class TeamsRepositoryImpl(
    private val local: DriversLocalService
) : TeamsRepository {

    override suspend fun getTeams(): List<Team> {

        val teams = local.selectDrivers().groupBy {
            it.teamName
        }

        return teams.map { (teamName, teamDrivers) ->
            Team(
                name = teamName,
                color = teamDrivers.firstOrNull()?.teamColour,
                drivers = teamDrivers.map {
                    TeamDriver(
                        name = it.fullName,
                        number = it.driverNumber
                    )
                }
            )
        }

    }

    override suspend fun getTeamByTeamName(name: String): Team? {
        return getTeams().find { it.name == name }
    }

}

