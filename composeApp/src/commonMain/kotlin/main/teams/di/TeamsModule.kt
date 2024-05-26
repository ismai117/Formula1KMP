package main.teams.di


import main.teams.data.local.TeamsLocalService
import main.teams.data.remote.TeamsRemoteService
import main.teams.data.repository.TeamsRepositoryImpl
import main.teams.domain.repository.TeamsRepository
import main.teams.presentation.TeamsViewModel
import org.koin.dsl.module


val teamsModule = module {
    single { TeamsRemoteService() }
    single { TeamsLocalService(get()) }
    single<TeamsRepository> { TeamsRepositoryImpl(get(), get()) }
    factory { TeamsViewModel(get()) }
}