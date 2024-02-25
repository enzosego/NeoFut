package com.ensegov.neofut.data.repository.detail

import com.ensegov.neofut.data.local.NeoFutDatabase
import com.ensegov.neofut.data.local.model.competition.standings.TeamInfo
import com.ensegov.neofut.data.local.model.competition.standings.asUiModel
import com.ensegov.neofut.data.local.model.fixture.RoundName
import com.ensegov.neofut.data.local.model.fixture.SimpleMatchFixture
import com.ensegov.neofut.data.remote.fixture.FixtureApi
import com.ensegov.neofut.data.remote.fixture.dto.asDatabaseModel
import com.ensegov.neofut.data.remote.standings.StandingsApi
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition
import com.ensegov.neofut.data.remote.standings.dto.asDatabaseModel
import com.ensegov.neofut.data.remote.team.dto.asDatabaseModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class CompetitionDetailRepositoryImpl(
    private val database: NeoFutDatabase,
    private val standingsDataSource: StandingsApi,
    private val fixtureDataSource: FixtureApi,
    private val ioDispatcher: CoroutineDispatcher
) : CompetitionDetailRepository {

    override suspend fun updateStandings(id: Int, season: Int) {
        val response = standingsDataSource.getCurrentStandings(id, season).asDatabaseModel()
            ?: return

        val positions = response.map { list ->
            list.map {
                it.asDatabaseModel(id, season)
            }
        }.flatten()
        val teams = response.map { list ->
            list.map {
                it.team.asDatabaseModel()
            }
        }.flatten()
        val teamForms = response.map { list ->
            list.map {
                listOf(
                    it.allMatches.asDatabaseModel(variation = "all", it.team.id),
                    it.homeMatches.asDatabaseModel(variation = "home", it.team.id),
                    it.awayMatches.asDatabaseModel(variation = "away", it.team.id)
                )
            }
        }.flatten().flatten()

        withContext(ioDispatcher) {
            database.standingsDao.insertPositions(*positions.toTypedArray())
            database.standingsDao.insertTeams(*teams.toTypedArray())
            database.standingsDao.insertTeamForms(*teamForms.toTypedArray())
        }
    }

    override fun getStandings(id: Int, season: Int): Flow<List<List<TeamPosition>>> =
        database.standingsDao.getStandings(id, season)
            .map { position -> position.asUiModel() }

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

    override suspend fun updateRoundFixture(id: Int, season: Int, round: String): List<SimpleMatchFixture> {
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
        return response
    }

    override fun getRoundFixture(id: Int, season: Int, round: String): Flow<List<SimpleMatchFixture>> =
            database.fixtureDao.getMatchFixture(id, season, round)
}