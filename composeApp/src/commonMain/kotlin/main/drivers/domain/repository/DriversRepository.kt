package main.drivers.domain.repository

import main.drivers.domain.model.Driver

interface DriversRepository {
    suspend fun getDrivers(): List<Driver>
    suspend fun getDriverByDriverNumber(driverNumber: Int): Driver
}