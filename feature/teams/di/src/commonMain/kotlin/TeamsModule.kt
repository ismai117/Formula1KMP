package commonMain

import local.TeamsLocalService
import platform.TeamsPlatformModule
import remote.TeamsRemoteService
import teams.TeamsRepository
import repository.TeamsRepositoryImpl

object TeamsModule {
    private val teamsRemoteService: TeamsRemoteService by lazy {
        TeamsRemoteService()
    }
    private val teamsLocalService: TeamsLocalService by lazy {
        TeamsLocalService(TeamsPlatformModule.kStore)
    }
    val teamsRepository: TeamsRepository by lazy {
        TeamsRepositoryImpl(teamsRemoteService, teamsLocalService)
    }
}