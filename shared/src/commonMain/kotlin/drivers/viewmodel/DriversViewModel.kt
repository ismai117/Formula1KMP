package drivers.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import drivers.domain.model.Driver
import drivers.domain.repository.DriversRepository
import getPlatform
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
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

    private val _state = MutableStateFlow(DriversState())
    val state = _state.asStateFlow()

    private val _driver = MutableStateFlow<Driver?>(null)
    val driver = _driver.asStateFlow()

    fun getDrivers() {
        viewModelScope.launch(getPlatform().dispatcherIO) {
            driversRepository.getDrivers()
                .collect { result ->
                    when (result) {
                        is Resource.Loading -> {
                            _state.update { it.copy(isLoading = true) }
                        }
                        is Resource.Success -> {
                            _state.update { it.copy(isLoading = false, status = true, drivers = result.data.orEmpty()) }
                        }
                        is Resource.Error -> {
                            _state.update { it.copy(isLoading = false, message = result.message) }
                        }
                    }
                }
        }
    }

    fun getDriverByDriverNumber(driverNumber: Int) {
        viewModelScope.launch(getPlatform().dispatcherIO) {
            _driver.update { driversRepository.getDriverByDriverNumber(driverNumber) }
        }
    }

}