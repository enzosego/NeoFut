package com.ensegov.neofut.competition_detail.presentation.standings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.competition_detail.data.repository.standings.StandingsRepository
import com.ensegov.neofut.competition_detail.presentation.standings.model.CompetitionGroup
import com.ensegov.neofut.common.presentation.model.UiState
import com.ensegov.neofut.common.presentation.model.updateFromNetwork
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class StandingsViewModel(
    private val standingsRepository: StandingsRepository,
    private val id: Int,
    private val season: Int
) : ViewModel() {

    val standings: MutableStateFlow<UiState<List<CompetitionGroup>>> =
        MutableStateFlow(UiState.Loading)

    init {
        getStandings()
    }

    private fun getStandings() {
        viewModelScope.launch {
            val newValue = standingsRepository.getStandings(id, season)
            if (newValue.isNotEmpty())
                standings.update { UiState.Success(newValue) }
            updateStandings()
        }
    }

    private fun updateStandings() = viewModelScope.launch {
        standings.update {
            standings.value.updateFromNetwork(
                canUpdate = { standingsRepository.canUpdateStandings(id, season) },
                request = { standingsRepository.updateStandings(id, season) },
                tag = TAG
            )
        }
    }

    companion object {
        private const val TAG = "StandingsViewModel"
    }
}