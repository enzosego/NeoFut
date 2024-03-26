package com.ensegov.neofut.match_detail.data.repository

import com.ensegov.neofut.NeoFutDatabase
import com.ensegov.neofut.match_detail.data.local.fixture.FullMatchFixture
import com.ensegov.neofut.match_detail.presentation.model.MatchCoverage
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class MatchDetailRepositoryImpl(
    private val database: NeoFutDatabase,
    private val ioDispatcher: CoroutineDispatcher
) : MatchDetailRepository {

    override fun getMatchDetail(matchId: Int): Flow<FullMatchFixture?> =
        database.fixtureDao.getFullMatchFixture(matchId)

    override suspend fun getCoverage(id: Int, season: Int): MatchCoverage = withContext(ioDispatcher) {
        database.fixtureDao.getMatchDetailCoverage(id, season)
    }
}