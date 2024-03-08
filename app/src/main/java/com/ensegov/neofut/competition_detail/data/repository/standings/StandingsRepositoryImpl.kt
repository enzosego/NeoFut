package com.ensegov.neofut.competition_detail.data.repository.standings

import android.util.Log
import com.ensegov.neofut.NeoFutDatabase
import com.ensegov.neofut.competition_detail.data.local.standings.asUiModel
import com.ensegov.neofut.competition_detail.data.remote.standings.StandingsApi
import com.ensegov.neofut.competition_detail.data.remote.standings.dto.asDatabaseModel
import com.ensegov.neofut.competition_detail.data.remote.standings.dto.asUiModel
import com.ensegov.neofut.competition_detail.data.remote.team.asDatabaseModel
import com.ensegov.neofut.competition_detail.presentation.standings.model.CompetitionGroup
import com.ensegov.neofut.update_times.data.local.UpdateTimeData
import com.ensegov.neofut.update_times.data.local.getTimeDiffInHours
import io.ktor.util.date.getTimeMillis
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class StandingsRepositoryImpl(
    private val database: NeoFutDatabase,
    private val standingsApi: StandingsApi,
    private val ioDispatcher: CoroutineDispatcher
) : StandingsRepository {

    override suspend fun updateStandings(id: Int, season: Int): List<CompetitionGroup> {
        val response = standingsApi.getCurrentStandings(id, season)

        val positions = response.flatMap { list ->
            list.map {
                it.asDatabaseModel(id, season)
            }
        }
        val teams = response.flatMap { list ->
            list.map {
                it.team.asDatabaseModel()
            }
        }
        val teamForms = response.flatMap { list ->
            list.flatMap {
                listOf(
                    it.allMatches.asDatabaseModel(variation = "all", it.team.id, id),
                    it.homeMatches.asDatabaseModel(variation = "home", it.team.id, id),
                    it.awayMatches.asDatabaseModel(variation = "away", it.team.id, id)
                )
            }
        }

        withContext(ioDispatcher) {
            database.standingsDao.insertStandingsData(positions, teams, teamForms)
            database.updateTimeDao.insertTime(
                UpdateTimeData(
                    type = "standings",
                    competitionId = id,
                    season = season,
                    time = getTimeMillis()
                )
            )
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

    override suspend fun canUpdateStandings(
        id: Int,
        season: Int
    ): Boolean = withContext(ioDispatcher) {
        val timeDiff = database.updateTimeDao.getLastUpdateTime(
            type = "standings",
            competitionId = id,
            season = season
        )?.getTimeDiffInHours()
        Log.d("StandingsRepository", "$timeDiff")
        timeDiff == null || timeDiff >= 24
    }
}