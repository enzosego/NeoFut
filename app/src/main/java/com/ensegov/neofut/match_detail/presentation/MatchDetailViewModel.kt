package com.ensegov.neofut.match_detail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.match_detail.data.local.fixture.FullMatchFixture
import com.ensegov.neofut.match_detail.data.repository.MatchDetailRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MatchDetailViewModel(
    private val matchDetailRepository: MatchDetailRepository,
    private val matchId: Int
) : ViewModel() {

    val matchDetail: StateFlow<FullMatchFixture?> = matchDetailRepository.getMatchDetail(matchId)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = null
        )

    init {
        getMatchDetail()
    }

    private fun getMatchDetail() = viewModelScope.launch {
        matchDetailRepository.getMatchDetail(matchId)
    }
}