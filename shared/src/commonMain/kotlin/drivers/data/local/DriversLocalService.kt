package drivers.data.local

import database.AppDatabase
import drivers.domain.model.Driver
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class DriversLocalService(
    private val db: AppDatabase
) {
    fun selectDrivers(): Flow<List<Driver>> {
        return db.driversDao().selectDrivers().mapToDomainModelListFlow()
    }

    suspend fun selectDriverByDriverNumber(driverNumber: Int): Driver {
        return db.driversDao().selectDriverByDriverNumber(driverNumber).first().mapToDomainModel()
    }

    suspend fun insertDriver(drivers: List<Driver>) {
        drivers.forEach { driver ->
            db.driversDao().insertDriver(driver.mapFromDomainModel())
        }
    }

}