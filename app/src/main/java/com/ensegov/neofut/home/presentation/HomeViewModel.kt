package com.ensegov.neofut.home.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.home.data.repository.CompetitionsRepository
import com.ensegov.neofut.home.presentation.model.CompetitionsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val competitionsRepository: CompetitionsRepository
) : ViewModel() {

    val competitionList: MutableStateFlow<CompetitionsUiState> =
        MutableStateFlow(CompetitionsUiState.Loading)

    init {
        updateCompetitions()
    }

    private fun updateCompetitions() {
        viewModelScope.launch {
            competitionList.update {
                try {
                    CompetitionsUiState.Success(
                        competitionsRepository.getAllCompetitions().ifEmpty {
                            competitionsRepository.fetchAllCompetitions("argentina")
                        }
                    )
                } catch (e: Exception) {
                    Log.d(TAG, "Error: $e")
                    CompetitionsUiState.Error
                }
            }
        }
    }

    companion object {
        private const val TAG = "HomeViewModel"
    }
}