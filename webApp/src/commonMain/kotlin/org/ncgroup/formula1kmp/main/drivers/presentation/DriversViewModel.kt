package org.ncgroup.formula1kmp.main.drivers.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ktor.client.utils.clientDispatcher
import io.ktor.utils.io.InternalAPI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import org.ncgroup.formula1kmp.io
import org.ncgroup.formula1kmp.main.drivers.domain.model.Driver
import org.ncgroup.formula1kmp.main.drivers.domain.repository.DriversRepository
import org.ncgroup.formula1kmp.utils.Resource

data class DriversState(
    val isLoading: Boolean = false,
    val status: Boolean = false,
    val message: String = "",
    val drivers: List<Driver> = emptyList()
)

class DriversViewModel(
    private val driversRepository: DriversRepository
) : ViewModel() {

    var state by mutableStateOf(DriversState())

    private val _driver = MutableStateFlow<Driver?>(null)
    val driver = _driver.asStateFlow()

    fun getDrivers() {
        viewModelScope.launch{
            driversRepository.getDrivers()
                .collect { result ->
                    state = when (result) {
                        is Resource.Loading -> {
                            state.copy(isLoading = true)
                        }
                        is Resource.Success -> {
                            state.copy(isLoading = false, status = true, drivers = result.data.orEmpty())
                        }
                        is Resource.Error -> {
                            state.copy(isLoading = false, message = result.message)
                        }
                    }
                }
        }
    }

    fun getDriverByDriverNumber(driverNumber: Int) {
        viewModelScope.launch(io()) {
            _driver.value = driversRepository.getDriverByDriverNumber(driverNumber)
        }
    }

}

