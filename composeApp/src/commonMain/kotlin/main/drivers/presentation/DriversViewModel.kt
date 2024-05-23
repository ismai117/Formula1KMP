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


class DriversViewModel(
    private val driversRepository: DriversRepository
) : ViewModel() {

    private val _drivers = MutableStateFlow<List<Driver>>(emptyList())
    val drivers = _drivers.asStateFlow()

    private val _driver = MutableStateFlow<Driver?>(null)
    val driver = _driver.asStateFlow()

    private val _isDriversLoading = MutableStateFlow(false)
    val isDriversLoading = _isDriversLoading.asStateFlow()


    init {
        getDrivers()
    }

    private fun getDrivers() {
        viewModelScope.launch(Dispatchers.IO) {
            _isDriversLoading.value = true
            if (driversRepository.getDrivers().isNotEmpty()) {
                _isDriversLoading.value = false
                _drivers.value = driversRepository.getDrivers()
            }
        }
    }

    fun getDriverByDriverNumber(driverNumber: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _driver.value = driversRepository.getDriverByDriverNumber(driverNumber)
        }
    }

}