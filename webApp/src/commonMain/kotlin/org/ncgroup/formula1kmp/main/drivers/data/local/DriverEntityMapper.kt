package org.ncgroup.formula1kmp.main.drivers.data.local

import com.ncgroup.formula1kmp.db.DriverEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.ncgroup.formula1kmp.main.drivers.domain.model.Driver


fun DriverEntity.mapToDomainModel(): Driver {
    return Driver(
        broadcastName = this.broadcastName,
        countryCode = this.countryCode,
        driverNumber = this.driverNumber.toInt(),
        firstName = this.firstName,
        fullName = this.fullName,
        lastName = this.lastName,
        meetingKey = this.meetingKey.toInt(),
        nameAcronym = this.nameAcronym,
        sessionKey = this.sessionKey.toInt(),
        teamColour = this.teamColour,
        teamName = this.teamName,
        countryImageUrl = this.countryImageUrl,
        driverNumberImage = this.driverNumberImage,
        headshotImageUrl = this.headshotImageUrl,
        profileImageUrl = this.profileImageUrl,
        biography = this.biography
    )
}

fun List<DriverEntity>.mapToDomainModelList(): List<Driver> {
    return this.map { it.mapToDomainModel() }
}

fun Flow<List<DriverEntity>>.mapToDomainModelListFlow(): Flow<List<Driver>> {
    return this.map { it.mapToDomainModelList() }
}

