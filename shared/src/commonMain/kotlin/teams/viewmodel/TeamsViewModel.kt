package teams.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import main.teams.domain.model.Team
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

    var state by mutableStateOf(TeamsState())

    private val _team = MutableStateFlow<Team?>(null)
    val team = _team.asStateFlow()


    fun getTeams() {
        viewModelScope.launch(Dispatchers.IO) {
            teamsRepository.getTeams()
                .flowOn(Dispatchers.Main)
                .collect { result ->
                    state = when (result) {
                        is Resource.Loading -> {
                            state.copy(isLoading = true)
                        }
                        is Resource.Success -> {
                            state.copy(isLoading = false, status = true, teams = result.data.orEmpty())
                        }
                        is Resource.Error -> {
                            state.copy(isLoading = false, message = result.message)
                        }
                    }
                }
        }
    }

    fun getTeamByTeamName(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _team.value = teamsRepository.getTeamByTeamName(name)
        }
    }

}