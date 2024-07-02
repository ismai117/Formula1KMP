package org.ncgroup.formula1kmp.main.drivers.data.local

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import app.cash.sqldelight.coroutines.mapToOne
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.single
import org.ncgroup.formula1kmp.db.AppDatabase
import org.ncgroup.formula1kmp.main.drivers.domain.model.Driver

class DriversLocalService(
    db: AppDatabase
){

    private val queries = db.driverEntityQueries

    suspend fun selectDrivers(): Flow<List<Driver>> {
        return queries.selectDrivers().asFlow().mapToList(Dispatchers.Unconfined).mapToDomainModelListFlow()
    }

    suspend fun selectDriverByDriverNumber(driverNumber: Int): Driver {
        return queries.selectDriverByDriverNumber(driverNumber.toLong()).executeAsOne().mapToDomainModel()
    }

    suspend fun insertDriver(drivers: List<Driver>) {
       drivers.forEach { driver ->
           queries.insertDriver(
               broadcastName = driver.broadcastName,
               countryCode = driver.countryCode,
               driverNumber = driver.driverNumber.toLong(),
               firstName = driver.firstName,
               fullName = driver.fullName,
               lastName = driver.lastName,
               meetingKey = driver.meetingKey.toLong(),
               nameAcronym = driver.nameAcronym,
               sessionKey = driver.sessionKey.toLong(),
               teamColour = driver.teamColour,
               teamName = driver.teamName,
               countryImageUrl = driver.countryImageUrl,
               driverNumberImage = driver.driverNumberImage,
               headshotImageUrl = driver.headshotImageUrl,
               profileImageUrl = driver.profileImageUrl,
               biography = driver.biography
           )
       }
    }

}