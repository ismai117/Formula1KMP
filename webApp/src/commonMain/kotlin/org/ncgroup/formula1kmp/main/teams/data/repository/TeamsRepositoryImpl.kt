package org.ncgroup.formula1kmp.main.teams.data.repository

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import org.ncgroup.formula1kmp.main.teams.data.remote.TeamsRemoteService
import org.ncgroup.formula1kmp.main.teams.domain.model.Team
import org.ncgroup.formula1kmp.main.teams.domain.repository.TeamsRepository
import org.ncgroup.formula1kmp.main.teams.data.local.TeamsLocalService
import org.ncgroup.formula1kmp.utils.Resource
import org.ncgroup.formula1kmp.utils.networkBoundResource

class TeamsRepositoryImpl(
    private val remote: TeamsRemoteService,
    private val local: TeamsLocalService
) : TeamsRepository {

    override suspend fun getTeams(): Flow<Resource<List<Team>>> {
        return networkBoundResource(
            query = { local.selectTeams() },
            fetch = { remote.getTeams() },
            saveFetchResult = { local.insertTeam(it) },
            shouldFetch = { it.isEmpty() }
        )
    }

    override suspend fun getTeamByTeamName(name: String): Team? {
        return local.selectTeamByName(name)
    }

}
