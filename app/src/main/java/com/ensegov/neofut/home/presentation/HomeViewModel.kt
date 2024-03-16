package com.ensegov.neofut.home.presentation

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
        MutableStateFlow(UiState.Success(emptyList()))

    init {
        getCompetitions()
    }

    private fun getCompetitions() = viewModelScope.launch {
        val newList = competitionsRepository.getAllCompetitions()
        competitionList.update {
            if (newList.isNotEmpty())
                UiState.Success(newList)
            else {
                updateCompetitions()
                UiState.Loading
            }
        }
    }

    private fun updateCompetitions() {
        viewModelScope.launch {
            competitionList.update {
                try {
                    UiState.Success(
                        competitionsRepository.fetchAllCompetitions("argentina")
                    )
                } catch (e: Exception) {
                    UiState.Error(message = e.message ?: "Could not retrieve competitions")
                }
            }
        }
    }
}