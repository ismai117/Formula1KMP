package ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import commonMain.StarterModule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import starter.StarterRepository
import kotlin.reflect.KClass

data class StarterState(
    val isLoading: Boolean = false,
    val status: Boolean = false,
    val message: String = "",
    val isStarted: Boolean = false
)


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
        viewModelScope.launch {
            starterRepository.getStartedState()
                .collect { result ->
                    _state.update { it.copy(isStarted = result ?: false) }
                }
        }
    }

    private fun setStartedState(){
        viewModelScope.launch {
            starterRepository.setStartedState()
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: KClass<T>, extras: CreationExtras): T {
                return StarterViewModel(
                    starterRepository = StarterModule.starterRepository
                ) as T
            }
        }
    }

}

sealed interface StarterOnEvent {
    data object STARTED : StarterOnEvent
}