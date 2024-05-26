package main.teams.data.remote

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import main.teams.domain.model.Team

class TeamsRemoteService() {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.d("HTTP Client", null, message)
                }
            }
            level = LogLevel.HEADERS
        }
    }.also { Napier.base(DebugAntilog()) }

    suspend fun getTeams(): List<Team> {
        val response = client.get {
            url("http://192.168.1.72:8080/teams")
        }.body<List<TeamDto>>()
        return response.mapToDomainModelList()
    }

}