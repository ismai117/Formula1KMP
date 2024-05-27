package main.teams.domain.repository

import kotlinx.coroutines.flow.Flow
import main.teams.domain.model.Team
import utils.Result

interface TeamsRepository {
    suspend fun getTeams(): Flow<Result<List<Team>>>
    suspend fun getTeamByTeamName(name: String): Team
}