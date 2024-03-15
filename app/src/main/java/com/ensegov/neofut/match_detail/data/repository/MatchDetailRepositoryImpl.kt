package com.ensegov.neofut.match_detail.data.repository

import com.ensegov.neofut.NeoFutDatabase
import com.ensegov.neofut.match_detail.data.local.fixture.FullMatchFixture
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class MatchDetailRepositoryImpl(
    private val database: NeoFutDatabase,
    private val ioDispatcher: CoroutineDispatcher
) : MatchDetailRepository {

    override suspend fun getMatchDetail(
        matchId: Int
    ): FullMatchFixture = withContext(ioDispatcher) {
        database.fixtureDao.getFullMatchFixture(matchId)
    }
}