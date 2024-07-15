package drivers

import kotlinx.serialization.Serializable

@Serializable
data class DriverEntity(
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
    val countryImageUrl: String,
    val driverNumberImage: String,
    val headshotImageUrl: String,
    val profileImageUrl: String,
    val biography: String
){
    companion object {
        fun Driver.fromDriver(): DriverEntity {
            return DriverEntity(
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
    }
    fun toDriver(): Driver {
        return Driver(
            id = null,
            broadcastName = broadcastName,
            countryCode = countryCode,
            driverNumber = driverNumber,
            firstName = firstName,
            fullName = fullName,
            lastName = lastName,
            meetingKey = meetingKey,
            nameAcronym = nameAcronym,
            sessionKey = sessionKey,
            teamColour = teamColour,
            teamName = teamName,
            countryImageUrl = countryImageUrl,
            driverNumberImage = driverNumberImage,
            headshotImageUrl = headshotImageUrl,
            profileImageUrl = profileImageUrl,
            biography = biography
        )
    }
}