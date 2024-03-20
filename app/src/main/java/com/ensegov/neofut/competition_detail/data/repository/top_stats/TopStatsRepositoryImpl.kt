package com.ensegov.neofut.competition_detail.data.repository.top_stats

import com.ensegov.neofut.NeoFutDatabase
import com.ensegov.neofut.competition_detail.data.local.top_stats.asUiModel
import com.ensegov.neofut.competition_detail.data.remote.top_stats.TopStatsApi
import com.ensegov.neofut.competition_detail.data.remote.top_stats.dto.asDatabaseModel
import com.ensegov.neofut.competition_detail.data.remote.player.asDatabaseModel
import com.ensegov.neofut.competition_detail.data.remote.top_stats.dto.PlayerStatsDto
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerStatsUiData
import com.ensegov.neofut.update_times.data.local.UpdateTimeData
import com.ensegov.neofut.update_times.data.local.getTimeDiffInDays
import io.ktor.util.date.getTimeMillis
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class TopStatsRepositoryImpl(
    private val database: NeoFutDatabase,
    private val topStatsApi: TopStatsApi,
    private val ioDispatcher: CoroutineDispatcher
) : TopStatsRepository {

    override fun getTopScorers(
        competitionId: Int,
        season: Int
    ): Flow<List<PlayerStatsUiData>> =
        database.topStatsDao.getTopScorers(competitionId, season)
            .map { statsList ->
                statsList.groupBy { it.goals.totalGoals }
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
    ) {
        updateStats(
            statsList = topStatsApi.getTopScorers(competitionId, season),
            type = "goals",
            competitionId,
            season
        )
    }

    override fun getTopAssists(
        competitionId: Int,
        season: Int
    ): Flow<List<PlayerStatsUiData>> =
        database.topStatsDao.getTopAssists(competitionId, season)
            .map { statsList ->
                statsList.groupBy { it.goals.assists }
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
    ) {
        updateStats(
            topStatsApi.getTopAssists(competitionId, season),
            type = "assists",
            competitionId,
            season
        )
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

    override suspend fun canUpdateTopStats(
        type: String,
        id: Int,
        season: Int,
    ): Boolean = withContext(ioDispatcher) {
        val timeDiff = database.updateTimeDao.getLastUpdateTime(
            type = type,
            competitionId = id,
            season = season
        )?.getTimeDiffInDays()
        timeDiff == null ||timeDiff >= 2
    }
}