package ui.main.drivers.data.remote

import ui.main.drivers.domain.model.Driver
import main.drivers.data.remote.DriverDto


fun DriverDto.mapToDomainModel(): Driver {
    return Driver(
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

fun List<DriverDto>.mapToDomainModelList(): List<Driver> {
    return this.map { it.mapToDomainModel() }
}

