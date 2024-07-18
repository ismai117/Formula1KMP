package remote

import Constants.BASE_URL
import client
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import teams.Team

class TeamsRemoteService() {
    suspend fun getTeams(): List<Team> {
        val response = client.get {
            url("$BASE_URL/teams")
        }.body<List<TeamDto>>()
        return response.map { it.toTeam() }
    }
}