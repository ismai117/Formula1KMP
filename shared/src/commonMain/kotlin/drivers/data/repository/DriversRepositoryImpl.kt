package drivers.data.repository

import drivers.data.local.DriversLocalService
import drivers.domain.repository.DriversRepository
import kotlinx.coroutines.flow.Flow
import main.drivers.data.remote.DriversRemoteService
import drivers.domain.model.Driver
import utils.Resource
import utils.networkBoundResource

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

