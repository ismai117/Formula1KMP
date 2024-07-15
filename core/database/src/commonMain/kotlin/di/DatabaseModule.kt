package di

import drivers.DriversLocalService
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import teams.TeamsLocalService

expect fun platformModule(): Module

val databaseModule = module {
    includes(platformModule())
    single { DriversLocalService(get((named("drivers_kstore")))) }
    single { TeamsLocalService(get((named("teams_kstore")))) }
}