package main.teams.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import main.drivers.domain.model.Driver
import main.teams.domain.model.Team
import main.teams.domain.repository.TeamsRepository


class TeamsViewModel(
    private val teamsRepository: TeamsRepository
) : ViewModel(){

    private val _teams = MutableStateFlow<List<Team>>(emptyList())
    val teams = _teams.asStateFlow()

    private val _team = MutableStateFlow<Team?>(null)
    val team = _team.asStateFlow()

    init {
        getDrivers()
    }

    private fun getDrivers() {
        viewModelScope.launch(Dispatchers.IO) {
            _teams.value = teamsRepository.getTeams()
        }
    }

    fun getTeamByTeamName(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _team.value = teamsRepository.getTeamByTeamName(name)
        }
    }

}