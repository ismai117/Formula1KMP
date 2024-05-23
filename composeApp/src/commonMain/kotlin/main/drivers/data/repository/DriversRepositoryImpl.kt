package main.drivers.data.repository

import main.drivers.data.local.DriversLocalService
import main.drivers.data.local.mapFromDomainModelList
import main.drivers.data.local.mapToDomainModel
import main.drivers.data.remote.DriversRemoteService
import main.drivers.domain.model.Driver
import main.drivers.domain.repository.DriversRepository

class DriversRepositoryImpl(
    private val remote: DriversRemoteService,
    private val local: DriversLocalService
) : DriversRepository {

    override suspend fun getDrivers(): List<Driver> {
        val drivers = local.selectDrivers()
        if (drivers.isEmpty()) return remote.getDrivers().also { local.insertDriver(it) }
        return drivers
    }

    override suspend fun getDriverByDriverNumber(driverNumber: Int): Driver {
        return local.selectDriverByDriverNumber(driverNumber).mapToDomainModel()
    }

}

