package org.ncgroup.formula1kmp.main.drivers.di

import org.ncgroup.formula1kmp.main.drivers.data.remote.DriversRemoteService
import org.ncgroup.formula1kmp.main.drivers.data.repository.DriversRepositoryImpl
import org.ncgroup.formula1kmp.main.drivers.domain.repository.DriversRepository
import org.koin.dsl.module
import org.ncgroup.formula1kmp.main.drivers.data.local.DriversLocalService
import org.ncgroup.formula1kmp.main.drivers.presentation.DriversViewModel

val driversModule = module {
    single { DriversRemoteService() }
    single { DriversLocalService(get()) }
    single<DriversRepository> { DriversRepositoryImpl(get(), get()) }
    factory { DriversViewModel(get()) }
}