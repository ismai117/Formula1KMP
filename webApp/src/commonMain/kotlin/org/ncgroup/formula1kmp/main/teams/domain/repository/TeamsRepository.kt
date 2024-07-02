package org.ncgroup.formula1kmp.main.teams.domain.repository

import kotlinx.coroutines.flow.Flow
import org.ncgroup.formula1kmp.main.teams.domain.model.Team
import org.ncgroup.formula1kmp.utils.Resource

interface TeamsRepository {
    suspend fun getTeams(): Flow<Resource<List<Team>>>
    suspend fun getTeamByTeamName(name: String): Team?
}