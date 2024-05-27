package main.drivers.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "drivers_table")
data class DriverEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
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
)