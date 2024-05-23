package main.teams.di

import main.teams.data.repository.TeamsRepositoryImpl
import main.teams.domain.repository.TeamsRepository
import main.teams.presentation.TeamsViewModel
import org.koin.dsl.module


val teamsModule = module {
    single<TeamsRepository> { TeamsRepositoryImpl(get()) }
    factory { TeamsViewModel(get()) }
}