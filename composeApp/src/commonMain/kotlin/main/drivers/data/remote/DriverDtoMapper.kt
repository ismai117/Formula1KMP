package main.drivers.data.remote

import main.drivers.domain.model.Driver


fun DriverDto.mapToDomainModel(): Driver {
    return Driver(
        id = null,
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
        profileImageUrl = this.profileImageUrl
    )
}

fun List<DriverDto>.mapToDomainModelList(): List<Driver> {
    return this.map { it.mapToDomainModel() }
}

