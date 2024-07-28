package commonMain

import io.github.xxfast.kstore.KStore
import local.TeamEntity
import local.TeamsLocalService
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides
import remote.TeamsRemoteService
import teams.TeamsRepository
import repository.TeamsRepositoryImpl
import ui.TeamDetailScreen
import ui.TeamsListScreen
import ui.TeamsViewModel

interface TeamsComponent {

    val teamsListScreen: TeamsListScreen
    val teamDetailScreen: TeamDetailScreen
    val teamsViewModel: TeamsViewModel

    @Provides
    fun teamsKStore(): KStore<List<TeamEntity>>

    @Provides
    fun provideTeamsRemoteService(): TeamsRemoteService = TeamsRemoteService()

    @Provides
    fun provideTeamsLocalService(
        kStore: KStore<List<TeamEntity>>,
    ): TeamsLocalService = TeamsLocalService(kStore)

    @Provides
    fun provideTeamsRepository(
        remote: TeamsRemoteService,
        local: TeamsLocalService,
    ): TeamsRepository = TeamsRepositoryImpl(remote, local)

}