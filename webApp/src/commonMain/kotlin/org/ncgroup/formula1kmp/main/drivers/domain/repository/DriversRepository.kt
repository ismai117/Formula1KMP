package org.ncgroup.formula1kmp.main.drivers.domain.repository

import kotlinx.coroutines.flow.Flow
import org.ncgroup.formula1kmp.main.drivers.domain.model.Driver
import org.ncgroup.formula1kmp.utils.Resource

interface DriversRepository {
    suspend fun getDrivers(): Flow<Resource<List<Driver>>>
    suspend fun getDriverByDriverNumber(driverNumber: Int): Driver?
}