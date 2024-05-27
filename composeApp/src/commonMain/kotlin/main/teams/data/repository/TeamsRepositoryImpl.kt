package main.teams.data.repository

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import main.teams.data.local.TeamsLocalService
import main.teams.data.remote.TeamsRemoteService
import main.teams.domain.model.Team
import main.teams.domain.repository.TeamsRepository
import utils.Result

class TeamsRepositoryImpl(
    private val remote: TeamsRemoteService,
    private val local: TeamsLocalService
) : TeamsRepository {

    override suspend fun getTeams(): Flow<Result<List<Team>>> = callbackFlow {
        try {
            trySend(Result.Loading)
            val teams = local.selectTeams()
            if (teams.isEmpty()){
                remote.getTeams().also { local.insertTeam(it) }
            }
            trySend(Result.Success(teams))
        }catch (e: Exception){
            trySend(Result.Error(e.message.toString()))
        }
        awaitClose { close() }
    }

    override suspend fun getTeamByTeamName(name: String): Team {
        return local.selectTeamByName(name)
    }

}
