package com.ensegov.neofut.match_detail.data.repository

import com.ensegov.neofut.match_detail.data.local.fixture.FullMatchFixture

interface MatchDetailRepository {

    suspend fun getMatchDetail(matchId: Int): FullMatchFixture
}