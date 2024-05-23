package main.teams.domain.model


data class Team(
    val name: String?,
    val color: String?,
    val drivers: List<TeamDriver>
)

data class TeamDriver(
    val name: String?,
    val number: Int?
)