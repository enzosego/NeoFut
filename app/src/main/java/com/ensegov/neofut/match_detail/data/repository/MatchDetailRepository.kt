package com.ensegov.neofut.match_detail.data.repository

import com.ensegov.neofut.match_detail.data.local.fixture.FullMatchFixture
import kotlinx.coroutines.flow.Flow

interface MatchDetailRepository {

    fun getMatchDetail(matchId: Int): Flow<FullMatchFixture?>
}