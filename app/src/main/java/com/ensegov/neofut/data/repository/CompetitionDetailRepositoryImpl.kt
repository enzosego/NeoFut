package com.ensegov.neofut.data.repository

import com.ensegov.neofut.data.local.NeoFutDatabase
import com.ensegov.neofut.data.local.model.competition.standings.CompetitionStandings
import com.ensegov.neofut.data.local.model.fixture.round.RoundFixtureData
import com.ensegov.neofut.data.local.model.fixture.season.SeasonFixtureData
import com.ensegov.neofut.data.remote.fixture.FixtureApi
import com.ensegov.neofut.data.remote.fixture.dto.asDatabaseModel
import com.ensegov.neofut.data.remote.standings.StandingsApi
import com.ensegov.neofut.data.remote.standings.dto.asDatabaseModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class CompetitionDetailRepositoryImpl(
    private val database: NeoFutDatabase,
    private val standingsDataSource: StandingsApi,
    private val fixtureDataSource: FixtureApi,
    private val ioDispatcher: CoroutineDispatcher
) : CompetitionDetailRepository {

    override suspend fun updateStandings(id: Int, season: Int) = withContext(ioDispatcher) {
        val newValue = standingsDataSource.getCurrentStandings(id, season).asDatabaseModel()
            ?: return@withContext
        database.standingsDao.upsert(newValue)
    }

    override fun getStandings(id: Int, season: Int): Flow<CompetitionStandings?> =
        database.standingsDao.getStandings(id, season)

    override suspend fun updateSeasonFixture(id: Int, season: Int) {
        val newValue = fixtureDataSource.getRounds(id, season).asDatabaseModel()
        database.seasonFixtureDao.upsert(newValue)
    }

    override fun getSeasonFixture(id: Int, season: Int): Flow<SeasonFixtureData> =
        database.seasonFixtureDao.getMatch(id, season)

    override suspend fun updateRoundFixture(id: Int, season: Int, round: String) {
        val newValue = fixtureDataSource.getFixture(id, season, round).asDatabaseModel()
        database.roundFixtureDao.upsert(newValue)
    }

    override fun getRoundFixture(id: Int, season: Int, round: String): Flow<RoundFixtureData?> =
        database.roundFixtureDao.getMatches(id, season, round)
}