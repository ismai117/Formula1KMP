package main.teams.domain.repository

import main.teams.domain.model.Team

interface TeamsRepository {
    suspend fun getTeams(): List<Team>
    suspend fun getTeamByTeamName(name: String): Team
}