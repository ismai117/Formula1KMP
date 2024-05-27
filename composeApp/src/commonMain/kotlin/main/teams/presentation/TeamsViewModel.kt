package main.teams.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import main.teams.domain.model.Team
import main.teams.domain.repository.TeamsRepository
import utils.Result


class TeamsViewModel(
    private val teamsRepository: TeamsRepository
) : ViewModel(){

    private val _team = MutableStateFlow<Team?>(null)
    val team = _team.asStateFlow()

    private val _state = MutableStateFlow(TeamsState())
    val state = _state.asStateFlow()

    fun getTeams() {
        viewModelScope.launch(Dispatchers.IO) {
            teamsRepository.getTeams().collect { result ->
                when(result){
                    is Result.Loading -> {
                        _state.value = TeamsState(
                            loading = true
                        )
                    }
                    is Result.Success -> {
                        _state.value = TeamsState(
                            loading = false,
                            success = true,
                            teams = result.data
                        )
                    }
                    is Result.Error -> {
                        _state.value = TeamsState(
                            loading = false,
                            error = result.message
                        )
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