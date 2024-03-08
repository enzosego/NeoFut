package com.ensegov.neofut.competition_detail.data.repository.top_stats

import com.ensegov.neofut.NeoFutDatabase
import com.ensegov.neofut.competition_detail.data.local.top_stats.asUiModel
import com.ensegov.neofut.competition_detail.data.remote.top_stats.TopStatsApi
import com.ensegov.neofut.competition_detail.data.remote.top_stats.dto.asDatabaseModel
import com.ensegov.neofut.competition_detail.data.remote.top_stats.dto.asUiModel
import com.ensegov.neofut.competition_detail.data.remote.player.asDatabaseModel
import com.ensegov.neofut.competition_detail.data.remote.top_stats.dto.PlayerStatsDto
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerStatsUiData
import com.ensegov.neofut.update_times.data.local.UpdateTimeData
import com.ensegov.neofut.update_times.data.local.getTimeDiffInDays
import io.ktor.util.date.getTimeMillis
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class TopStatsRepositoryImpl(
    private val database: NeoFutDatabase,
    private val topStatsApi: TopStatsApi,
    private val ioDispatcher: CoroutineDispatcher
) : TopStatsRepository {

    override suspend fun getTopScorers(
        competitionId: Int,
        season: Int
    ): List<PlayerStatsUiData> =
        withContext(ioDispatcher) {
            database.topStatsDao.getTopScorers(competitionId, season)
                .groupBy { it.goals.totalGoals }
                .map { it.value }
                .flatMapIndexed { index, list ->
                    list.map { scorer ->
                        scorer.asUiModel(position = index + 1)
                    }
                }
                .sortedWith(
                    compareByDescending<PlayerStatsUiData> { it.totalGoals }
                        .thenBy { it.penaltyGoals }
                )
        }

    override suspend fun updateTopScorers(
        competitionId: Int,
        season: Int
    ): List<PlayerStatsUiData> {
        val response = topStatsApi.getTopScorers(competitionId, season)
        updateStats(response, type = "goals", competitionId, season)

        return response
            .groupBy { it.statistics[0].goals.total }
            .map { it.value }
            .flatMapIndexed { index, list ->
                list.map { scorer ->
                    scorer.asUiModel(position = index + 1)
                }
            }
            .sortedWith(
                compareByDescending<PlayerStatsUiData> { it.totalGoals }
                    .thenBy { it.penaltyGoals }
            )
    }

    override suspend fun getTopAssists(
        competitionId: Int,
        season: Int
    ): List<PlayerStatsUiData> =
        withContext(ioDispatcher) {
            database.topStatsDao.getTopAssists(competitionId, season)
                .groupBy { it.goals.assists }
                .map { it.value }
                .flatMapIndexed { index, list ->
                    list.map { player ->
                        player.asUiModel(position = index + 1)
                    }
                }
                .sortedWith(compareByDescending { it.assists })
        }

    override suspend fun updateTopAssists(
        competitionId: Int,
        season: Int
    ): List<PlayerStatsUiData> {
        val response = topStatsApi.getTopAssists(competitionId, season)
        updateStats(response, type = "assists", competitionId, season)

        return response
            .groupBy { it.statistics[0].goals.assists }
            .map { it.value }
            .flatMapIndexed { index, list ->
                list.map { scorer ->
                    scorer.asUiModel(position = index + 1)
                }
            }
            .sortedWith(compareByDescending { it.assists })
    }

    private suspend fun updateStats(
        statsList: List<PlayerStatsDto>,
        type: String,
        competitionId: Int,
        season: Int,
    ) {
        val stats = statsList.map {
            it.statistics[0].asDatabaseModel(it.player.id ,competitionId, season, type)
        }
        val players = statsList.map {
            it.player.asDatabaseModel(it.statistics[0].team.id)
        }
        withContext(ioDispatcher) {
            database.topStatsDao.insertStatsAndPlayerData(stats, players)
            database.updateTimeDao.insertTime(
                 UpdateTimeData(
                     type = type,
                     competitionId = competitionId,
                     season = season,
                     time = getTimeMillis()
                 )
            )
        }
    }

    override suspend fun canUpdateTopScorers(
        id: Int,
        season: Int
    ): Boolean = withContext(ioDispatcher) {
        val timeDiff = database.updateTimeDao.getLastUpdateTime(
            type = "goals",
            competitionId = id,
            season = season
        )?.getTimeDiffInDays()
        timeDiff == null ||timeDiff >= 2
    }

    override suspend fun canUpdateTopAssists(
        id: Int,
        season: Int
    ): Boolean = withContext(ioDispatcher) {
        val timeDiff = database.updateTimeDao.getLastUpdateTime(
            type = "assists",
            competitionId = id,
            season = season
        )?.getTimeDiffInDays()
        timeDiff == null ||timeDiff >= 2
    }
}