package org.ncgroup.formula1kmp.starter.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.ncgroup.formula1kmp.io
import org.ncgroup.formula1kmp.main.drivers.domain.repository.DriversRepository
import org.ncgroup.formula1kmp.main.teams.domain.repository.TeamsRepository
import starter.domain.repository.StarterRepository

class StarterViewModel(
    private val starterRepository: StarterRepository
) : ViewModel() {

    private val _state = MutableStateFlow(StarterState())
    val state = _state.asStateFlow()

    init {
        getStartedState()
    }

    fun onEvent(event: StarterOnEvent){
        when(event){
            StarterOnEvent.STARTED -> {
                setStartedState()
            }
        }
    }

    private fun getStartedState(){
        viewModelScope.launch(io()) {
            starterRepository.getStartedState()
                .collect { result ->
                    _state.value = StarterState(isStarted = result ?: false)
                }
        }
    }

    private fun setStartedState(){
        viewModelScope.launch(io()) {
            starterRepository.setStartedState()
        }
    }

}