package main.drivers.data.repository

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import main.drivers.data.local.DriversLocalService
import main.drivers.data.local.mapToDomainModel
import main.drivers.data.remote.DriversRemoteService
import main.drivers.domain.model.Driver
import main.drivers.domain.repository.DriversRepository
import utils.Result

class DriversRepositoryImpl(
    private val remote: DriversRemoteService,
    private val local: DriversLocalService
) : DriversRepository {

    override suspend fun getDrivers(): Flow<Result<List<Driver>>> = callbackFlow {
        try {
            trySend(Result.Loading)
            val drivers = local.selectDrivers()
            if (drivers.isEmpty()){
                remote.getDrivers().also { local.insertDriver(it) }
            }
            trySend(Result.Success(drivers))
        }catch (e: Exception){
            trySend(Result.Error(e.message.toString()))
        }
        awaitClose { close() }
    }

    override suspend fun getDriverByDriverNumber(driverNumber: Int): Driver {
        return local.selectDriverByDriverNumber(driverNumber).mapToDomainModel()
    }

}

