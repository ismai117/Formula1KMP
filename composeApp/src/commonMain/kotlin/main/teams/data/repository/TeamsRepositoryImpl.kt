package main.teams.data.repository

import main.teams.data.local.TeamsLocalService
import main.teams.data.remote.TeamsRemoteService
import main.teams.domain.model.Team
import main.teams.domain.repository.TeamsRepository

class TeamsRepositoryImpl(
    private val remote: TeamsRemoteService,
    private val local: TeamsLocalService
) : TeamsRepository {

    override suspend fun getTeams(): List<Team> {
        val teams = local.selectTeams()
        if (teams.isEmpty()) return remote.getTeams().also { local.insertTeam(it) }
        return teams
    }

    override suspend fun getTeamByTeamName(name: String): Team {
        return local.selectTeamByName(name)
    }

}
