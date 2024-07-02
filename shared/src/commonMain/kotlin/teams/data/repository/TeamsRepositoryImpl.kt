package teams.data.repository

import kotlinx.coroutines.flow.Flow
import main.teams.data.remote.TeamsRemoteService
import main.teams.domain.model.Team
import teams.data.local.TeamsLocalService
import teams.domain.repository.TeamsRepository
import utils.Resource
import utils.networkBoundResource

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

    override suspend fun getTeamByTeamName(name: String): Team {
        return local.selectTeamByName(name)
    }

}
