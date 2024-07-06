package drivers.data.local

import drivers.domain.model.Driver
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


fun DriverEntity.mapToDomainModel(): Driver {
    return Driver(
        id = this.id,
        broadcastName = this.broadcastName,
        countryCode = this.countryCode,
        driverNumber = this.driverNumber,
        firstName = this.firstName,
        fullName = this.fullName,
        lastName = this.lastName,
        meetingKey = this.meetingKey,
        nameAcronym = this.nameAcronym,
        sessionKey = this.sessionKey,
        teamColour = this.teamColour,
        teamName = this.teamName,
        countryImageUrl = this.countryImageUrl,
        driverNumberImage = this.driverNumberImage,
        headshotImageUrl = this.headshotImageUrl,
        profileImageUrl = this.profileImageUrl,
        biography = this.biography
    )
}

fun Driver.mapFromDomainModel(): DriverEntity {
    return DriverEntity(
        id = this.id,
        broadcastName = this.broadcastName,
        countryCode = this.countryCode,
        driverNumber = this.driverNumber,
        firstName = this.firstName,
        fullName = this.fullName,
        lastName = this.lastName,
        meetingKey = this.meetingKey,
        nameAcronym = this.nameAcronym,
        sessionKey = this.sessionKey,
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

fun List<Driver>.mapFromDomainModelList(): List<DriverEntity> {
    return this.map { it.mapFromDomainModel() }
}

fun Flow<List<DriverEntity>>.mapToDomainModelListFlow(): Flow<List<Driver>> {
    return this.map { it.mapToDomainModelList() }
}