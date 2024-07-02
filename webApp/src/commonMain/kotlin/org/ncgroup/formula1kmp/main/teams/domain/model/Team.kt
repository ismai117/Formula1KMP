package org.ncgroup.formula1kmp.main.teams.domain.model

data class Team(
    val name: String,
    val fullName: String,
    val logoUrl: String,
    val carImageUrl: String,
    val teamColour: String,
    val drivers: List<TeamDriver>,
    val base: String,
    val chassis: String,
    val fastestLaps: Int,
    val firstTeamEntry: Int,
    val highestRaceFinish: String,
    val polePositions: Int,
    val powerUnit: String,
    val teamChief: String,
    val technicalChief: String,
    val worldChampionships: Int
)

data class TeamDriver(
    val driverNumber: Int,
    val fullName: String,
    val profileImageUrl: String
)