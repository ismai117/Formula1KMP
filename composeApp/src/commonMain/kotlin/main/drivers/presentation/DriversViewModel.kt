package main.drivers.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import main.drivers.domain.model.Driver
import main.drivers.domain.repository.DriversRepository
import utils.Result


class DriversViewModel(
    private val driversRepository: DriversRepository
) : ViewModel() {

    private val _driver = MutableStateFlow<Driver?>(null)
    val driver = _driver.asStateFlow()

    private val _state = MutableStateFlow(DriversState())
    val state = _state.asStateFlow()

    fun getDrivers() {
        viewModelScope.launch(Dispatchers.IO) {
            driversRepository.getDrivers().collect { result ->
                when(result){
                    is Result.Loading -> {
                        _state.value = DriversState(
                            loading = true
                        )
                    }
                    is Result.Success -> {
                        _state.value = DriversState(
                            loading = false,
                            success = true,
                            drivers = result.data
                        )
                    }
                    is Result.Error -> {
                        _state.value = DriversState(
                            loading = false,
                            error = result.message
                        )
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