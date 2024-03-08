package com.ensegov.neofut.competition_detail.data.repository.fixture

import com.ensegov.neofut.NeoFutDatabase
import com.ensegov.neofut.competition_detail.data.local.team.TeamInfo
import com.ensegov.neofut.competition_detail.data.local.fixture.RoundName
import com.ensegov.neofut.competition_detail.data.local.fixture.asShortUiModel
import com.ensegov.neofut.competition_detail.data.remote.fixture.FixtureApi
import com.ensegov.neofut.competition_detail.data.remote.fixture.dto.asDatabaseModel
import com.ensegov.neofut.competition_detail.presentation.fixture.model.MatchUiShort
import com.ensegov.neofut.update_times.data.local.UpdateTimeData
import com.ensegov.neofut.update_times.data.local.getTimeDiffInDays
import com.ensegov.neofut.update_times.data.local.getTimeDiffInHours
import io.ktor.util.date.getTimeMillis
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class FixtureRepositoryImpl(
    private val database: NeoFutDatabase,
    private val fixtureDataSource: FixtureApi,
    private val ioDispatcher: CoroutineDispatcher
) : FixtureRepository {

    override suspend fun updateSeasonFixture(id: Int, season: Int) = withContext(ioDispatcher) {
        val lastUpdate = database.updateTimeDao.getLastUpdateTime(
            type = "season_fixture",
            competitionId = id,
            season = season
        )
        if (lastUpdate != null && lastUpdate.getTimeDiffInDays() <= 15)
            return@withContext

        val newValue = fixtureDataSource.getRounds(id, season)
            .map { RoundName(
                competitionId = id,
                season = season,
                name = it
            ) }
        database.fixtureDao.insertAllRounds(newValue)
        database.updateTimeDao.insertTime(
            UpdateTimeData(
                type = "season_fixture",
                competitionId = id,
                season = season,
                time = getTimeMillis(),
            )
        )
    }

    override fun getSeasonFixture(id: Int, season: Int): Flow<List<String>> =
        database.fixtureDao.getSeasonRounds(id, season)

    override suspend fun updateRoundFixture(
        id: Int,
        season: Int,
        round: String
    ): List<MatchUiShort> = withContext(ioDispatcher) {

        val response = fixtureDataSource.getFixture(id, season, round)
            .mapNotNull { it.asDatabaseModel(id, season, round) }
        val matches = response.map { it.data }
        val teams = mutableListOf<TeamInfo>()
        teams.addAll(response.map { it.homeTeam })
        teams.addAll(response.map { it.awayTeam })

        database.fixtureDao.insertTeamsAndMatches(matches, teams)
        database.updateTimeDao.insertTime(
            UpdateTimeData(
                type = "round_fixture",
                competitionId = id,
                season = season,
                time = getTimeMillis(),
            )
        )
        response.map { it.asShortUiModel() }
    }

    override fun getRoundFixture(id: Int, season: Int, round: String): Flow<List<MatchUiShort>> =
            database.fixtureDao.getMatchFixture(id, season, round)
                .map { list ->
                    list.map { it.asShortUiModel() }
                }

    override suspend fun canUpdateSeasonRounds(
        id: Int,
        season: Int
    ): Boolean = withContext(ioDispatcher) {
        val timeDiff = database.updateTimeDao.getLastUpdateTime(
            type = "round_fixture",
            competitionId = id,
            season = season
        )?.getTimeDiffInDays()
        timeDiff == null || timeDiff >= 24
    }

    override suspend fun canUpdateRoundFixture(
        id: Int,
        season: Int
    ): Boolean = withContext(ioDispatcher) {
        val timeDiff = database.updateTimeDao.getLastUpdateTime(
            type = "round_fixture",
            competitionId = id,
            season = season
        )?.getTimeDiffInHours()
        timeDiff == null || timeDiff >= 24
    }
}