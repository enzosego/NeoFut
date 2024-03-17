package com.ensegov.neofut.competition_detail.presentation.standings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.competition_detail.data.repository.standings.StandingsRepository
import com.ensegov.neofut.competition_detail.presentation.standings.model.CompetitionGroup
import com.ensegov.neofut.common.presentation.model.UiState
import com.ensegov.neofut.common.presentation.model.updateFromNetwork
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class StandingsViewModel(
    private val standingsRepository: StandingsRepository,
    private val id: Int,
    private val season: Int
) : ViewModel() {

    private val _standings: MutableStateFlow<UiState<List<CompetitionGroup>>> =
        MutableStateFlow(UiState.Success(emptyList()))
    val standings = _standings.asStateFlow()

    var isUpdatingFromNetwork by mutableStateOf(false)
        private set

    init {
        getStandings()
    }

    private fun getStandings() {
        viewModelScope.launch {
            val newValue = standingsRepository.getStandings(id, season)
            _standings.update {
                if (newValue.isNotEmpty())
                    UiState.Success(newValue)
                else
                    UiState.Loading
            }
            updateStandings()
        }
    }

    private fun updateStandings() = viewModelScope.launch {
        _standings.value.updateFromNetwork(
            canUpdate = { standingsRepository.canUpdateStandings(id, season) },
            update = { newValue -> _standings.update { newValue } },
            request = { standingsRepository.updateStandings(id, season) },
            changeIsUpdatingValue = { isUpdatingFromNetwork = it }
        )
    }
}