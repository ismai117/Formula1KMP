package org.ncgroup.formula1kmp.main.drivers.domain.model

data class Driver(
    val broadcastName: String,
    val countryCode: String,
    val driverNumber: Int,
    val firstName: String,
    val fullName: String,
    val lastName: String,
    val meetingKey: Int,
    val nameAcronym: String,
    val sessionKey: Int,
    val teamColour: String,
    val teamName: String,
    val headshotImageUrl: String,
    val profileImageUrl: String,
    val driverNumberImage: String,
    val countryImageUrl: String,
    val biography: String
)
