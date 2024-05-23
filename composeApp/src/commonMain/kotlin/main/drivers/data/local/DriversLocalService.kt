package main.drivers.data.local


import database.AppDatabase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import main.drivers.domain.model.Driver


class DriversLocalService(
    private val db: AppDatabase
) {

    suspend fun selectDrivers(): List<Driver> {
        return db.driversDao().selectDrivers().first().mapToDomainModelList()
    }

    suspend fun selectDriverByDriverNumber(driverNumber: Int): DriverEntity {
        return db.driversDao().selectDriverByDriverNumber(driverNumber).first()
    }

    suspend fun insertDriver(drivers: List<Driver>) {
        drivers.forEach { driver ->
            db.driversDao().insertDriver(driver.mapFromDomainModel())
        }
    }

}

