package com.ensegov.neofut.home.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.home.data.repository.CompetitionsRepository
import com.ensegov.neofut.home.presentation.model.Competition
import com.ensegov.neofut.common.presentation.model.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val competitionsRepository: CompetitionsRepository
) : ViewModel() {

    val competitionList: MutableStateFlow<UiState<List<Competition>>> =
        MutableStateFlow(UiState.Loading)

    init {
        updateCompetitions()
    }

    private fun updateCompetitions() {
        viewModelScope.launch {
            competitionList.update {
                try {
                    UiState.Success(
                        competitionsRepository.getAllCompetitions().ifEmpty {
                            competitionsRepository.fetchAllCompetitions("argentina")
                        }
                    )
                } catch (e: Exception) {
                    Log.d(TAG, "Error: $e")
                    UiState.Error
                }
            }
        }
    }

    companion object {
        private const val TAG = "HomeViewModel"
    }
}