package ui.main.drivers.di

import ui.main.drivers.presentation.DriversViewModel
import ui.main.drivers.data.remote.DriversRemoteService
import ui.main.drivers.data.repository.DriversRepositoryImpl
import ui.main.drivers.domain.repository.DriversRepository
import org.koin.dsl.module

val driversModule = module {
    single { DriversRemoteService() }
    single<DriversRepository> { DriversRepositoryImpl(get()) }
    factory { DriversViewModel(get()) }
}