package ui.main.drivers.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ui.main.drivers.domain.model.Driver
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import ui.main.drivers.domain.repository.DriversRepository
import utils.Resource

data class DriversState(
    val isLoading: Boolean = false,
    val status: Boolean = false,
    val message: String = "",
    val drivers: List<Driver> = emptyList(),
    val driver: Driver? = null
)

class DriversViewModel(
    private val driversRepository: DriversRepository
) : ViewModel() {

    private val _state = MutableStateFlow(DriversState())
    val state = _state.asStateFlow()

    fun getDrivers() {
        viewModelScope.launch{
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
        viewModelScope.launch {
            _state.update { it.copy(driver = driversRepository.getDriverByDriverNumber(driverNumber)) }
        }
    }

}