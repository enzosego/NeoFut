package com.ensegov.neofut.competition_detail.presentation.standings

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.competition_detail.data.repository.standings.StandingsRepository
import com.ensegov.neofut.competition_detail.presentation.standings.model.CompetitionGroup
import com.ensegov.neofut.common.presentation.model.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class StandingsViewModel(
    private val standingsRepository: StandingsRepository,
    private val competitionId: Int,
    private val competitionSeason: Int
) : ViewModel() {

    val standings: MutableStateFlow<UiState<List<CompetitionGroup>>> =
        MutableStateFlow(UiState.Loading)

    init {
        getStandings()
    }

    private fun getStandings() {
        viewModelScope.launch {
            val newValue = standingsRepository.getStandings(competitionId, competitionSeason)
            if (newValue.isNotEmpty())
                standings.update { UiState.Success(newValue) }
            updateStandings()
        }
    }

    private fun updateStandings() = viewModelScope.launch {
        if (standingsRepository.canUpdateStandings(competitionId, competitionSeason))
            try {
                standings.update {
                    UiState.Success(
                        standingsRepository.updateStandings(competitionId, competitionSeason)
                    )
                }
            } catch (e: Exception) {
                standings.update { UiState.Error }
                Log.d(TAG, "${e.message}")
            }
    }

    companion object {
        private const val TAG = "StandingsViewModel"
    }
}