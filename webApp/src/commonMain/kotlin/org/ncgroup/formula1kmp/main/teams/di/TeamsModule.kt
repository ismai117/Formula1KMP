package org.ncgroup.formula1kmp.main.teams.di

import org.ncgroup.formula1kmp.main.teams.data.remote.TeamsRemoteService
import org.ncgroup.formula1kmp.main.teams.data.repository.TeamsRepositoryImpl
import org.ncgroup.formula1kmp.main.teams.domain.repository.TeamsRepository
import org.koin.dsl.module
import org.ncgroup.formula1kmp.main.teams.data.local.TeamsLocalService
import org.ncgroup.formula1kmp.main.teams.presentation.TeamsViewModel

val teamsModule = module {
    single { TeamsRemoteService() }
    single { TeamsLocalService(get()) }
    single<TeamsRepository> { TeamsRepositoryImpl(get(), get()) }
    factory { TeamsViewModel(get()) }
}