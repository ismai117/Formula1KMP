package main.drivers.domain.repository

import kotlinx.coroutines.flow.Flow
import main.drivers.domain.model.Driver
import utils.Result

interface DriversRepository {
    suspend fun getDrivers(): Flow<Result<List<Driver>>>
    suspend fun getDriverByDriverNumber(driverNumber: Int): Driver
}