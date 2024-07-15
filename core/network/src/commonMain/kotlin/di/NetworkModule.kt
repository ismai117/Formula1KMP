package di

import drivers.DriversRemoteService
import org.koin.dsl.module
import teams.TeamsRemoteService

val networkModule = module {
    single<DriversRemoteService> { DriversRemoteService() }
    single<TeamsRemoteService>{ TeamsRemoteService() }
}