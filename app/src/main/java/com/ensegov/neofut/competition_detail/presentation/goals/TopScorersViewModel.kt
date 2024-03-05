package com.ensegov.neofut.competition_detail.presentation.goals

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.competition_detail.presentation.goals.model.TopScorersUiState
import com.ensegov.neofut.competition_detail.repository.goals.TopScorersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TopScorersViewModel(
    private val topScorersRepository: TopScorersRepository,
    private val competitionId: Int,
    private val competitionSeason: Int
) : ViewModel() {

    private val _topScorers: MutableStateFlow<TopScorersUiState> =
        MutableStateFlow(TopScorersUiState.Loading)
    val topScorers: StateFlow<TopScorersUiState> = _topScorers

    init {
        getTopScorers()
    }

    private fun getTopScorers() {
        _topScorers.update { TopScorersUiState.Loading }
        viewModelScope.launch {
            val newValue = topScorersRepository.getTopScorers(competitionId, competitionSeason)
            _topScorers.update {
                try {
                    TopScorersUiState.Success(
                        newValue.ifEmpty {
                            topScorersRepository
                                .updateTopScorers(competitionId, competitionSeason)
                        }
                    )
                } catch (e: Exception) {
                    Log.d(TAG, "${e.message}")
                    TopScorersUiState.Error
                }
            }
        }
    }

    companion object {
        const val TAG = "TopScorersViewModel"
    }
}