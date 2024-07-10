package ui.main.teams.di

import ui.main.teams.data.remote.TeamsRemoteService
import ui.main.teams.data.repository.TeamsRepositoryImpl
import ui.main.teams.domain.repository.TeamsRepository
import org.koin.dsl.module
import ui.main.teams.presentation.TeamsViewModel


val teamsModule = module {
    single { TeamsRemoteService() }
    single<TeamsRepository> { TeamsRepositoryImpl(get()) }
    factory { TeamsViewModel(get()) }
}