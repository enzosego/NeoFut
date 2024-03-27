package com.ensegov.neofut.match_detail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.match_detail.data.local.fixture.FullMatchFixture
import com.ensegov.neofut.match_detail.data.repository.MatchDetailRepository
import com.ensegov.neofut.match_detail.presentation.tab.MatchDetailTab
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MatchDetailViewModel(
    private val matchDetailRepository: MatchDetailRepository,
    private val matchId: Int,
) : ViewModel() {

    val matchDetail: StateFlow<FullMatchFixture?> = matchDetailRepository.getMatchDetail(matchId)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = null
        )

    val matchDetailTabs: StateFlow<List<MatchDetailTab>> = matchDetail.map { fixture ->
        if (fixture == null)
            return@map emptyList()
        val coverage = matchDetailRepository.getCoverage(
            fixture.data.competitionId,
            fixture.data.season
        )
        listOf(
            MatchDetailTab.Info(hasCoverage = coverage.events),
            MatchDetailTab.Lineups(hasCoverage = coverage.lineups),
            MatchDetailTab.Stats(hasCoverage = coverage.statistics)
        ).filter { it.hasCoverage }
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = emptyList()
        )

    init {
        getMatchDetail()
    }

    private fun getMatchDetail() = viewModelScope.launch {
        matchDetailRepository.getMatchDetail(matchId)
    }

    companion object {
        const val TIMEOUT_MILLIS = 5000L
    }
}