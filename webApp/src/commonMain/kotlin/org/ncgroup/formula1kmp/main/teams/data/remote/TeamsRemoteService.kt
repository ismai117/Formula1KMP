package org.ncgroup.formula1kmp.main.teams.data.remote

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.ncgroup.formula1kmp.main.teams.domain.model.Team
import org.ncgroup.formula1kmp.utils.Constants.BASE_URL

class TeamsRemoteService {

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
                    Napier.d(message, null)
                }
            }
            level = LogLevel.BODY
        }
    }.also { Napier.base(DebugAntilog()) }

    suspend fun getTeams(): List<Team> {
        val response = client.get {
            url("$BASE_URL/teams")
        }.body<List<TeamDto>>()
        return response.mapToDomainModelList()
    }

}

