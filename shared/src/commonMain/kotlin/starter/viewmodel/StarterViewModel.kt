package starter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import getPlatform
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
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
        viewModelScope.launch(getPlatform().dispatcherIO) {
            starterRepository.getStartedState()
                .collect { result ->
                    _state.update { it.copy(isStarted = result ?: false) }
                }
        }
    }

    private fun setStartedState(){
        viewModelScope.launch(getPlatform().dispatcherIO) {
            starterRepository.setStartedState()
        }
    }

}