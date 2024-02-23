package com.ensegov.neofut.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.data.repository.competitions.CompetitionsRepository
import com.ensegov.neofut.ui.competition.model.Competition
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

private const val TAG = "HomeViewModel"

class HomeViewModel(
    private val competitionsRepository: CompetitionsRepository
) : ViewModel() {

    lateinit var competitionList: StateFlow<List<Competition>>

    fun getCompetitions() {
        val newValue = competitionsRepository.getAllCompetitions()
        competitionList = newValue
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
        viewModelScope.launch {
            if (newValue.first().isEmpty())
                updateCompetitions()
        }
    }

    private suspend fun updateCompetitions() {
        try {
            competitionsRepository.fetchAllCompetitions("argentina")
        } catch (e: Exception) {
            Log.d(TAG, "Error: $e")
        }
    }
}