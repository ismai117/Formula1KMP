package teams.domain.repository

import kotlinx.coroutines.flow.Flow
import main.teams.domain.model.Team
import utils.Resource

interface TeamsRepository {
    suspend fun getTeams(): Flow<Resource<List<Team>>>
    suspend fun getTeamByTeamName(name: String): Team
}