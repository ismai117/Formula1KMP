package main.drivers.presentation

import main.drivers.domain.model.Driver

data class DriversState(
    val loading: Boolean = false,
    val success: Boolean = false,
    val error: String = "",

    val drivers: List<Driver> = emptyList()
)
