package ui.main.drivers.data.repository

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import ui.main.drivers.domain.repository.DriversRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import ui.main.drivers.data.remote.DriversRemoteService
import ui.main.drivers.domain.model.Driver
import utils.Resource

class DriversRepositoryImpl(
    private val remote: DriversRemoteService
) : DriversRepository {

    private val _drivers = mutableListOf<Driver>()

    override suspend fun getDrivers(): Flow<Resource<List<Driver>>> = callbackFlow {
        try {
            trySend(Resource.Loading())
            val drivers = remote.getDrivers()
            if (drivers.isNotEmpty()){
                _drivers.addAll(drivers)
                trySend(Resource.Success(drivers))
            }
        }catch (e: Exception){
            trySend(Resource.Error(e.message.toString()))
        }
        awaitClose { close() }
    }

    override suspend fun getDriverByDriverNumber(driverNumber: Int): Driver? {
        return _drivers.find { it.driverNumber == driverNumber }
    }

}

