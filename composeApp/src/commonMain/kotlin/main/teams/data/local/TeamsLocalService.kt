package main.teams.data.local


import database.AppDatabase
import kotlinx.coroutines.flow.first
import main.teams.domain.model.Team


class TeamsLocalService(
    private val db: AppDatabase
) {

    suspend fun selectTeams(): List<Team> {
        return db.teamsDao().selectTeams().first().mapToDomainModelList()
    }

    suspend fun selectTeamByName(name: String): Team {
        return db.teamsDao().selectTeamByName(name).first().mapToDomainModel()
    }

    suspend fun insertTeam(teams: List<Team>) {
        teams.forEach { team ->
            db.teamsDao().insertTeam(team.mapFromDomainModel())
        }
    }

}

