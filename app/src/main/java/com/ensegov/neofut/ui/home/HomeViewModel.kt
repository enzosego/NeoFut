package com.ensegov.neofut.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.data.repository.competitions.CompetitionsRepository
import com.ensegov.neofut.ui.competition.model.Competition
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    private val competitionsRepository: CompetitionsRepository
) : ViewModel() {

    val competitionList: StateFlow<List<Competition>> = competitionsRepository.getAllCompetitions()
        .onEach { if (it.isEmpty()) updateCompetitions() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = emptyList()
        )

    private suspend fun updateCompetitions() {
        try {
            competitionsRepository.fetchAllCompetitions("argentina")
        } catch (e: Exception) {
            Log.d(TAG, "Error: $e")
        }
    }

    companion object {
        private const val TAG = "HomeViewModel"
        private const val TIMEOUT_MILLIS = 5000L
    }
}