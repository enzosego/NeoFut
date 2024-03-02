package com.ensegov.neofut.competition_detail.repository

import com.ensegov.neofut.NeoFutDatabase
import com.ensegov.neofut.competition_detail.data.local.team.TeamInfo
import com.ensegov.neofut.competition_detail.data.local.standings.asUiModel
import com.ensegov.neofut.competition_detail.data.local.fixture.RoundName
import com.ensegov.neofut.competition_detail.data.local.fixture.asShortUiModel
import com.ensegov.neofut.competition_detail.data.remote.fixture.FixtureApi
import com.ensegov.neofut.competition_detail.data.remote.fixture.dto.asDatabaseModel
import com.ensegov.neofut.competition_detail.data.remote.standings.StandingsApi
import com.ensegov.neofut.competition_detail.data.remote.standings.dto.asDatabaseModel
import com.ensegov.neofut.competition_detail.data.remote.standings.dto.asUiModel
import com.ensegov.neofut.competition_detail.data.remote.team.asDatabaseModel
import com.ensegov.neofut.competition_detail.presentation.fixture.model.MatchUiShort
import com.ensegov.neofut.competition_detail.presentation.standings.model.CompetitionGroup
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class CompetitionDetailRepositoryImpl(
    private val database: NeoFutDatabase,
    private val standingsDataSource: StandingsApi,
    private val fixtureDataSource: FixtureApi,
    private val ioDispatcher: CoroutineDispatcher
) : CompetitionDetailRepository {

    override suspend fun updateStandings(id: Int, season: Int): List<CompetitionGroup> {
        val response = standingsDataSource.getCurrentStandings(id, season).asDatabaseModel()
            ?: return emptyList()

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
                    it.allMatches.asDatabaseModel(variation = "all", it.team.id, id),
                    it.homeMatches.asDatabaseModel(variation = "home", it.team.id, id),
                    it.awayMatches.asDatabaseModel(variation = "away", it.team.id, id)
                )
            }
        }.flatten().flatten()

        withContext(ioDispatcher) {
            database.standingsDao.insertPositions(*positions.toTypedArray())
            database.standingsDao.insertTeams(*teams.toTypedArray())
            database.standingsDao.insertTeamForms(*teamForms.toTypedArray())
        }
        return response.map { list ->
            CompetitionGroup(
                groupName = list[0].group,
                teamList = list.map { it.asUiModel() }
            )
        }
    }

    override suspend fun getStandings(id: Int, season: Int): List<CompetitionGroup> =
        withContext(ioDispatcher) {
            database.standingsDao.getStandings(id, season).asUiModel()
        }

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