package ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import commonMain.TeamsModule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import teams.Team
import kotlinx.coroutines.Dispatchers
import teams.TeamsRepository
import utils.Resource
import kotlin.reflect.KClass

data class TeamsState(
    val isLoading: Boolean = false,
    val status: Boolean = false,
    val message: String = "",
    val teams: List<Team> = emptyList()
)

class TeamsViewModel(
    private val teamsRepository: TeamsRepository
) : ViewModel(){

    private val _state = MutableStateFlow(TeamsState())
    val state = _state.asStateFlow()

    private val _team = MutableStateFlow<Team?>(null)
    val team = _team.asStateFlow()

    fun getTeams() {
        viewModelScope.launch {
            teamsRepository.getTeams()
                .collect { result ->
                     when (result) {
                        is Resource.Loading -> {
                            _state.update { it.copy(isLoading = true) }
                        }
                        is Resource.Success -> {
                            _state.update { it.copy(isLoading = false, status = true, teams = result.data.orEmpty()) }
                        }
                        is Resource.Error -> {
                            _state.update { it.copy(isLoading = false, message = result.message) }
                        }
                    }
                }
        }
    }

    fun getTeamByTeamName(name: String) {
        viewModelScope.launch {
            _team.update { teamsRepository.getTeamByTeamName(name) }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: KClass<T>, extras: CreationExtras): T {
                return TeamsViewModel(
                    teamsRepository = TeamsModule.teamsRepository
                ) as T
            }
        }
    }

}