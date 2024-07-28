package repository

import kotlinx.coroutines.flow.Flow
import local.TeamsLocalService
import me.tatarka.inject.annotations.Inject
import remote.TeamsRemoteService
import teams.Team
import teams.TeamsRepository
import utils.Resource
import utils.networkBoundResource

@Inject
class TeamsRepositoryImpl(
    private val remote: TeamsRemoteService,
    private val local: TeamsLocalService
) : TeamsRepository {

    override fun getTeams(): Flow<Resource<List<Team>>> {
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
