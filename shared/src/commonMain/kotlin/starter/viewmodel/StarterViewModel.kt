package starter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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
        viewModelScope.launch(Dispatchers.IO) {
            starterRepository.getStartedState()
                .collect { result ->
                    _state.value = StarterState(isStarted = result ?: false)
                }
        }
    }

    private fun setStartedState(){
        viewModelScope.launch(Dispatchers.IO) {
            starterRepository.setStartedState()
        }
    }

}