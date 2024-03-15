package com.ensegov.neofut.match_detail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.common.presentation.model.UiState
import com.ensegov.neofut.match_detail.data.local.fixture.FullMatchFixture
import com.ensegov.neofut.match_detail.data.repository.MatchDetailRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MatchDetailViewModel(
    private val matchDetailRepository: MatchDetailRepository,
    private val matchId: Int
) : ViewModel() {

    private val _matchDetail = MutableStateFlow<UiState<FullMatchFixture>>(UiState.Loading)
    val matchDetail: StateFlow<UiState<FullMatchFixture>> = _matchDetail

    init {
        getMatchDetail()
    }

    private fun getMatchDetail() = viewModelScope.launch {
        _matchDetail.update {
            UiState.Success(matchDetailRepository.getMatchDetail(matchId))
        }
    }
}