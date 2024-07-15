package teams

import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.extensions.getOrEmpty
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import teams.TeamEntity.Companion.fromTeam

class TeamsLocalService(
    private val kStore: KStore<List<TeamEntity>>
) {

    fun selectTeams(): Flow<List<Team>> {
        return kStore.updates
            .map { entries ->
                entries.orEmpty().map { it.toTeam() }
            }
    }

    suspend fun selectTeamByName(name: String): Team? {
        val teamEntity = kStore.getOrEmpty().map { it.toTeam() }
        return teamEntity.find { it.name == name }
    }

    suspend fun insertTeam(teams: List<Team>) {
        kStore.set(teams.map { it.fromTeam() })
    }

}