package com.ensegov.neofut.competition_detail.presentation.standings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.competition_detail.data.repository.standings.StandingsRepository
import com.ensegov.neofut.competition_detail.presentation.standings.model.CompetitionGroup
import com.ensegov.neofut.common.presentation.model.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class StandingsViewModel(
    private val standingsRepository: StandingsRepository,
    private val id: Int,
    private val season: Int
) : ViewModel() {

    val standings: StateFlow<List<CompetitionGroup>> =
        standingsRepository.getStandings(id, season)
            .onEach {
                if (it.isEmpty())
                    _uiState.update { UiState.Loading }
                updateStandings()
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000L),
                initialValue = emptyList()
            )

    private val _uiState = MutableStateFlow<UiState<Boolean>>(UiState.Success(data = false))
    val uiState = _uiState.asStateFlow()

    var isUpdating by mutableStateOf(value = false)
        private set

    private fun updateStandings() = viewModelScope.launch {
        if (standingsRepository.canUpdateStandings(id, season)) {
            isUpdating = true
            _uiState.update { state ->
                try {
                    standingsRepository.updateStandings(id, season)
                    UiState.Success(false)
                } catch (e: Exception) {
                    if (state is UiState.Loading)
                        UiState.Error(e.message ?: "")
                    else
                        UiState.Success(data = false)
                }
            }
            isUpdating = false
        }
    }
}