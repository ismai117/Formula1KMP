package remote

import Constants.BASE_URL
import client
import drivers.Driver
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url

class DriversRemoteService {
    suspend fun getDrivers(): List<Driver> {
        val response = client.get {
            url("$BASE_URL/drivers")
        }.body<List<DriverDto>>()
        return response.map { it.toDriver() }
    }
}