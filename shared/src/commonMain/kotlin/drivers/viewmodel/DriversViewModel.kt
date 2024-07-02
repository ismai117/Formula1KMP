package drivers.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import main.drivers.domain.model.Driver
import drivers.domain.repository.DriversRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import utils.Resource

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
        viewModelScope.launch(Dispatchers.IO) {
            driversRepository.getDrivers()
                .flowOn(Dispatchers.Main)
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
        viewModelScope.launch(Dispatchers.IO) {
            _driver.value = driversRepository.getDriverByDriverNumber(driverNumber)
        }
    }

}