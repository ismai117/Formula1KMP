package teams.data.local

import database.AppDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import teams.domain.model.Team

class TeamsLocalService(
    private val db: AppDatabase
) {

    fun selectTeams(): Flow<List<Team>> {
        return db.teamsDao().selectTeams().mapToDomainModelListFlow()
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