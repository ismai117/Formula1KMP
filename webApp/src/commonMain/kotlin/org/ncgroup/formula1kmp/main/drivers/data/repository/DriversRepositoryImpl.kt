package org.ncgroup.formula1kmp.main.drivers.data.repository

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import org.ncgroup.formula1kmp.main.drivers.data.remote.DriversRemoteService
import org.ncgroup.formula1kmp.main.drivers.data.local.DriversLocalService
import org.ncgroup.formula1kmp.main.drivers.domain.model.Driver
import org.ncgroup.formula1kmp.main.drivers.domain.repository.DriversRepository
import org.ncgroup.formula1kmp.utils.Resource
import org.ncgroup.formula1kmp.utils.networkBoundResource

class DriversRepositoryImpl(
    private val remote: DriversRemoteService,
    private val local: DriversLocalService
) : DriversRepository {

    override suspend fun getDrivers(): Flow<Resource<List<Driver>>> {
        return networkBoundResource(
            query = { local.selectDrivers() },
            fetch = { remote.getDrivers() },
            saveFetchResult = { local.insertDriver(it) },
            shouldFetch = { it.isEmpty() }
        )
    }

    override suspend fun getDriverByDriverNumber(driverNumber: Int): Driver? {
        return local.selectDriverByDriverNumber(driverNumber)
    }

}

