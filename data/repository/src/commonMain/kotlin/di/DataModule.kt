package di

import drivers.DriversRepository
import drivers.DriversRepositoryImpl
import org.koin.dsl.module
import starter.StarterRepository
import starter.StarterRepositoryImpl
import teams.TeamsRepository
import teams.TeamsRepositoryImpl

val dataModule = module {
    single<DriversRepository> { DriversRepositoryImpl(get(), get()) }
    single<TeamsRepository> { TeamsRepositoryImpl(get(), get()) }
    single<StarterRepository> { StarterRepositoryImpl(get()) }
}