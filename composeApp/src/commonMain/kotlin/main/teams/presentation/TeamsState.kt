package main.teams.presentation

import main.teams.domain.model.Team

data class TeamsState(
    val loading: Boolean = false,
    val success: Boolean = false,
    val error: String = "",

    val teams: List<Team> = emptyList()
)
