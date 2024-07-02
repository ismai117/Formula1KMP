package org.ncgroup.formula1kmp.main.drivers.data.remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DriverDto(
    @SerialName("broadcastName")
    val broadcastName: String,
    @SerialName("countryCode")
    val countryCode: String,
    @SerialName("countryImageUrl")
    val countryImageUrl: String,
    @SerialName("driverNumber")
    val driverNumber: Int,
    @SerialName("driverNumberImage")
    val driverNumberImage: String,
    @SerialName("firstName")
    val firstName: String,
    @SerialName("fullName")
    val fullName: String,
    @SerialName("headshotImageUrl")
    val headshotImageUrl: String,
    @SerialName("lastName")
    val lastName: String,
    @SerialName("meetingKey")
    val meetingKey: Int,
    @SerialName("nameAcronym")
    val nameAcronym: String,
    @SerialName("profileImageUrl")
    val profileImageUrl: String,
    @SerialName("sessionKey")
    val sessionKey: Int,
    @SerialName("teamColour")
    val teamColour: String,
    @SerialName("teamName")
    val teamName: String,
    @SerialName("biography")
    val biography: String
)