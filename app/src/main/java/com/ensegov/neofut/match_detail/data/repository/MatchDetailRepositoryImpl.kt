package com.ensegov.neofut.match_detail.data.repository

import com.ensegov.neofut.NeoFutDatabase
import com.ensegov.neofut.match_detail.data.local.fixture.FullMatchFixture
import kotlinx.coroutines.flow.Flow

class MatchDetailRepositoryImpl(
    private val database: NeoFutDatabase
) : MatchDetailRepository {

    override fun getMatchDetail(matchId: Int): Flow<FullMatchFixture?> =
        database.fixtureDao.getFullMatchFixture(matchId)
}