package main.drivers.di

import main.drivers.data.local.DriversLocalService
import main.drivers.data.remote.DriversRemoteService
import main.drivers.data.repository.DriversRepositoryImpl
import main.drivers.domain.repository.DriversRepository
import main.drivers.presentation.DriversViewModel
import org.koin.dsl.module


val driversModule = module {
    single { DriversRemoteService() }
    single { DriversLocalService(get()) }
    single<DriversRepository> { DriversRepositoryImpl(get(), get()) }
    factory { DriversViewModel(get()) }
}