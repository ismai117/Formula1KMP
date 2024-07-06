package teams.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import getPlatform
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import teams.domain.model.Team
import teams.domain.repository.TeamsRepository
import utils.Resource

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
        viewModelScope.launch(getPlatform().dispatcherIO) {
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
        viewModelScope.launch(getPlatform().dispatcherIO) {
            _team.update { teamsRepository.getTeamByTeamName(name) }
        }
    }

}