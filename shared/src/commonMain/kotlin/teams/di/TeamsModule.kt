package teams.di

import main.teams.data.remote.TeamsRemoteService
import teams.data.repository.TeamsRepositoryImpl
import teams.domain.repository.TeamsRepository
import org.koin.dsl.module
import teams.data.local.TeamsLocalService
import teams.viewmodel.TeamsViewModel


val teamsModule = module {
    single { TeamsRemoteService() }
    single { TeamsLocalService(get()) }
    single<TeamsRepository> { TeamsRepositoryImpl(get(), get()) }
    factory { TeamsViewModel(get()) }
}