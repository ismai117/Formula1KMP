package drivers.di

import drivers.data.local.DriversLocalService
import drivers.viewmodel.DriversViewModel
import main.drivers.data.remote.DriversRemoteService
import drivers.data.repository.DriversRepositoryImpl
import drivers.domain.repository.DriversRepository
import org.koin.dsl.module

val driversModule = module {
    single { DriversRemoteService() }
    single { DriversLocalService(get()) }
    single<DriversRepository> { DriversRepositoryImpl(get(), get()) }
    factory { DriversViewModel(get()) }
}