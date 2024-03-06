package com.ensegov.neofut.competition_detail.presentation.standings

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.competition_detail.presentation.standings.model.StandingsUiState
import com.ensegov.neofut.competition_detail.data.repository.standings.StandingsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class StandingsViewModel(
    private val standingsRepository: StandingsRepository,
    private val competitionId: Int,
    private val competitionSeason: Int
) : ViewModel() {

    val standings: MutableStateFlow<StandingsUiState> =
        MutableStateFlow(StandingsUiState.Loading)

    init {
        getStandings()
    }

    private fun getStandings() {
        standings.update { StandingsUiState.Loading }
        viewModelScope.launch {
            val newValue = standingsRepository.getStandings(competitionId, competitionSeason)
            standings.update {
                try {
                    StandingsUiState.Success(
                        newValue.ifEmpty {
                            standingsRepository
                                .updateStandings(competitionId, competitionSeason)
                        }
                    )
                } catch (e: Exception) {
                    Log.d(TAG, "${e.message}")
                    StandingsUiState.Error
                }
            }
        }
    }

    companion object {
        private const val TAG = "CompetitionDetailViewModel"
    }
}