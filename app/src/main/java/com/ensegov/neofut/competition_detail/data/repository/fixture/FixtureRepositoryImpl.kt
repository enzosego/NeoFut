package com.ensegov.neofut.competition_detail.data.repository.fixture

import com.ensegov.neofut.NeoFutDatabase
import com.ensegov.neofut.competition_detail.data.local.team.TeamInfo
import com.ensegov.neofut.competition_detail.data.remote.team.asDatabaseModel
import com.ensegov.neofut.match_detail.data.local.fixture.RoundName
import com.ensegov.neofut.match_detail.data.local.fixture.SimpleMatchFixture
import com.ensegov.neofut.match_detail.data.local.fixture.asShortUiModel
import com.ensegov.neofut.match_detail.data.local.fixture.getDate
import com.ensegov.neofut.match_detail.data.remote.fixture.FixtureApi
import com.ensegov.neofut.match_detail.data.remote.fixture.dto.asDatabaseModel
import com.ensegov.neofut.competition_detail.presentation.fixture.model.MatchDay
import com.ensegov.neofut.match_detail.data.remote.fixture.dto.match.asDatabaseModel
import com.ensegov.neofut.update_times.data.local.UpdateTimeData
import com.ensegov.neofut.update_times.data.local.getTimeDiffInDays
import com.ensegov.neofut.update_times.data.local.getTimeDiffInHours
import io.ktor.util.date.getTimeMillis
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class FixtureRepositoryImpl(
    private val database: NeoFutDatabase,
    private val fixtureApi: FixtureApi,
    private val ioDispatcher: CoroutineDispatcher
) : FixtureRepository {

    override suspend fun updateSeasonRounds(id: Int, season: Int) = withContext(ioDispatcher) {
        val lastUpdate = database.updateTimeDao.getLastUpdateTime(
            type = "season_fixture",
            competitionId = id,
            season = season
        )
        if (lastUpdate != null && lastUpdate.getTimeDiffInDays() <= 15)
            return@withContext

        val newValue = fixtureApi.getRounds(id, season)
            .mapIndexed { index, name ->
                RoundName(
                index = index,
                competitionId = id,
                season = season,
                name = name
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
        updateCurrentRound(id, season)
    }

    override fun getSeasonRounds(id: Int, season: Int): Flow<List<RoundName>> =
        database.fixtureDao.getSeasonRounds(id, season)

    override suspend fun updateCurrentRound(id: Int, season: Int) {
        if (!canUpdateCurrentRound(id, season))
            return
        database.fixtureDao.updateCurrentRound(
            roundName = fixtureApi.getCurrentRound(id, season),
            id = id,
            season = season
        )
    }

    override suspend fun updateRoundFixture(
        id: Int,
        season: Int,
        round: String
    ): List<MatchDay> = withContext(ioDispatcher) {

        val response = fixtureApi.getFixture(id, season, round)
        val databaseModel = response
            .mapNotNull { it.asDatabaseModel(id, season, round) }

        val matches = databaseModel.map { it.data }

        val scoreList = response.mapNotNull { fixture ->
            fixture.score?.asDatabaseModel(fixture.info.id)
        }.flatten()
        val venueList = response.mapNotNull { fixture ->
            fixture.info.venue.asDatabaseModel()
        }

        val teams = mutableListOf<TeamInfo>()
        teams.addAll(databaseModel.map { it.homeTeam })
        teams.addAll(databaseModel.map { it.awayTeam })

        database.fixtureDao.insertAllFixtureData(matches, scoreList, teams, venueList)
        database.updateTimeDao.insertTime(
            UpdateTimeData(
                type = "round_fixture",
                competitionId = id,
                season = season,
                roundName = round,
                time = getTimeMillis(),
            )
        )
        databaseModel.sortToUiModel()
    }

    override suspend fun getRoundFixture(
        id: Int,
        season: Int,
        round: String
    ): List<MatchDay> = withContext(ioDispatcher) {
        database.fixtureDao.getMatchFixture(id, season, round)
            .sortToUiModel()
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

    override suspend fun canUpdateCurrentRound(
        id: Int,
        season: Int
    ): Boolean = withContext(ioDispatcher) {
        val timeDiff = database.updateTimeDao.getLastUpdateTime(
            type = "current_round",
            competitionId = id,
            season = season
        )?.getTimeDiffInDays()
        timeDiff == null || timeDiff >= 2
    }

    override suspend fun canUpdateRoundFixture(
        id: Int,
        season: Int,
        round: String
    ): Boolean = withContext(ioDispatcher) {
        val timeDiff = database.updateTimeDao.getLastUpdateTime(
            type = "round_fixture",
            competitionId = id,
            roundName = round,
            season = season
        )?.getTimeDiffInHours()
        timeDiff == null || timeDiff >= 24
    }
}

private fun List<SimpleMatchFixture>.sortToUiModel(): List<MatchDay> =
    this.groupBy { Pair(it.data.getDate().year, it.data.getDate().dayOfYear) }
        .toSortedMap(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
        .map { (_, list) ->
            val date = list[0].data.getDate()
            MatchDay(
                date = "${date.dayOfWeek} ${date.month} ${date.dayOfMonth}",
                matchList = list.sortedWith(compareBy { it.data.date })
                    .map { it.asShortUiModel() }
            )
        }
