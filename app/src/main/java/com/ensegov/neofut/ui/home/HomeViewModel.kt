package com.ensegov.neofut.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.data.remote.competition.dto.Competition
import com.ensegov.neofut.data.repository.CompetitionsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val competitionsRepository: CompetitionsRepository
) : ViewModel() {

    init {
        getAllCompetitions()
    }

    private val _competitionList = MutableStateFlow<List<Competition>>(listOf())
    val competitionList: StateFlow<List<Competition>> get() = _competitionList

    private fun getAllCompetitions() = viewModelScope.launch {
        val newList = competitionsRepository.getAllCompetitions()
        _competitionList.emit(newList)
    }
}