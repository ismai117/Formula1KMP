package commonMain

import drivers.DriversRepository
import drivers.DriversRepositoryImpl
import local.DriversLocalService
import platform.DriversPlatformModule
import remote.DriversRemoteService

object DriversModule {
    private val driversRemoteService: DriversRemoteService by lazy {
        DriversRemoteService()
    }
    private val driversLocalService: DriversLocalService by lazy {
        DriversLocalService(DriversPlatformModule.kStore)
    }
    val driversRepository: DriversRepository by lazy {
        DriversRepositoryImpl(driversRemoteService, driversLocalService)
    }
}