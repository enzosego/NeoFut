package com.ensegov.neofut.match_detail.data.repository

import com.ensegov.neofut.match_detail.data.local.fixture.FullMatchFixture
import com.ensegov.neofut.match_detail.presentation.model.MatchCoverage
import kotlinx.coroutines.flow.Flow

interface MatchDetailRepository {

    fun getMatchDetail(matchId: Int): Flow<FullMatchFixture?>

    suspend fun getCoverage(id: Int, season: Int): MatchCoverage
}