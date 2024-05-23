package main.drivers.data.remote

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
import main.drivers.domain.model.Driver


class DriversRemoteService() {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
        install(Logging){
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.d("HTTP Client", null, message)
                }
            }
            level = LogLevel.HEADERS
        }
        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }
    }.also { Napier.base(DebugAntilog()) }

    suspend fun getDrivers(): List<Driver> {
        val response = client.get {
            url("https://api.openf1.org/v1/drivers")
        }.body<List<DriverDto>>()
        val drivers = response.distinctBy { it.driverNumber }.filter { latestDrivers.contains(it.driverNumber) }.mapToDomainModelList()
        println("count: ${drivers.count()}, drivers: ${drivers}")
        return drivers
    }

}


private val latestDrivers = listOf(
    1,
    16,
    11,
    4,
    55,
    81,
    63,
    44,
    14,
    22,
    18,
    38,
    27,
    3,
    31,
    20,
    23,
    24,
    10,
    77,
    2
)