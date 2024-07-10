package ui.main.drivers.domain.repository

import kotlinx.coroutines.flow.Flow
import ui.main.drivers.domain.model.Driver
import utils.Resource

interface DriversRepository {
    suspend fun getDrivers(): Flow<Resource<List<Driver>>>
    suspend fun getDriverByDriverNumber(driverNumber: Int): Driver?
}