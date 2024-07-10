package ui.main.teams.data.repository

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import ui.main.teams.data.remote.TeamsRemoteService
import ui.main.teams.domain.model.Team
import ui.main.teams.domain.repository.TeamsRepository
import utils.Resource

class TeamsRepositoryImpl(
    private val remote: TeamsRemoteService
) : TeamsRepository {

    private val _teams = mutableListOf<Team>()

    override suspend fun getTeams(): Flow<Resource<List<Team>>>  = callbackFlow {
        try {
            trySend(Resource.Loading())
            val teams = remote.getTeams()
            if (teams.isNotEmpty()){
                _teams.addAll(teams)
                trySend(Resource.Success(teams))
            }
        }catch (e: Exception){
            trySend(Resource.Error(e.message.toString()))
        }
        awaitClose { close() }
    }

    override suspend fun getTeamByTeamName(name: String): Team? {
        return _teams.find { it.name == name }
    }

}
