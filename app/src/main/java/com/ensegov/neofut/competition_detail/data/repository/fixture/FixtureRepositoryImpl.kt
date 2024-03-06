package com.ensegov.neofut.competition_detail.data.repository.fixture

import com.ensegov.neofut.NeoFutDatabase
import com.ensegov.neofut.competition_detail.data.local.team.TeamInfo
import com.ensegov.neofut.competition_detail.data.local.fixture.RoundName
import com.ensegov.neofut.competition_detail.data.local.fixture.asShortUiModel
import com.ensegov.neofut.competition_detail.data.remote.fixture.FixtureApi
import com.ensegov.neofut.competition_detail.data.remote.fixture.dto.asDatabaseModel
import com.ensegov.neofut.competition_detail.presentation.fixture.model.MatchUiShort
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class FixtureRepositoryImpl(
    private val database: NeoFutDatabase,
    private val fixtureDataSource: FixtureApi,
    private val ioDispatcher: CoroutineDispatcher
) : FixtureRepository {

    override suspend fun updateSeasonFixture(id: Int, season: Int) {
        val newValue = fixtureDataSource.getRounds(id, season).roundList
            .map { RoundName(
                competitionId = id,
                season = season,
                name = it
            ) }
        withContext(ioDispatcher) {
            database.fixtureDao.insertAllRounds(*newValue.toTypedArray())
        }
    }

    override fun getSeasonFixture(id: Int, season: Int): Flow<List<String>> =
        database.fixtureDao.getSeasonRounds(id, season)

    override suspend fun updateRoundFixture(id: Int, season: Int, round: String): List<MatchUiShort> {
        val response = fixtureDataSource.getFixture(id, season, round).fixture
            .mapNotNull { it.asDatabaseModel(id, season, round) }
        val matches = response.map { it.data }
        val teams = mutableListOf<TeamInfo>()
        teams.addAll(response.map { it.homeTeam })
        teams.addAll(response.map { it.awayTeam })

        withContext(ioDispatcher) {
            database.fixtureDao.insertAllMatches(*matches.toTypedArray())
            database.fixtureDao.insertAllTeams(*teams.toTypedArray())
        }
        return response.map { it.asShortUiModel() }
    }

    override fun getRoundFixture(id: Int, season: Int, round: String): Flow<List<MatchUiShort>> =
            database.fixtureDao.getMatchFixture(id, season, round)
                .map { list ->
                    list.map { it.asShortUiModel() }
                }
}