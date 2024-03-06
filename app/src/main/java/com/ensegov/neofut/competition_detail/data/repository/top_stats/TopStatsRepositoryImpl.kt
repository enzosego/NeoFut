package com.ensegov.neofut.competition_detail.data.repository.top_stats

import com.ensegov.neofut.NeoFutDatabase
import com.ensegov.neofut.competition_detail.data.local.top_stats.asUiModel
import com.ensegov.neofut.competition_detail.data.remote.top_stats.TopStatsApi
import com.ensegov.neofut.competition_detail.data.remote.top_stats.dto.asDatabaseModel
import com.ensegov.neofut.competition_detail.data.remote.top_stats.dto.asUiModel
import com.ensegov.neofut.competition_detail.data.remote.player.asDatabaseModel
import com.ensegov.neofut.competition_detail.data.remote.top_stats.dto.PlayerStatsDto
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerStatsUiData
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

    override suspend fun getTopScorersFromNetwork(
        competitionId: Int,
        season: Int
    ): List<PlayerStatsUiData> {
        val response = topStatsApi.getTopScorers(competitionId, season).response
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

    override suspend fun getTopAssistsFromNetwork(
        competitionId: Int,
        season: Int
    ): List<PlayerStatsUiData> {
        val response = topStatsApi.getTopAssists(competitionId, season).response
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
        season: Int
    ) {
        val goalStats = statsList.map {
            it.statistics[0].asDatabaseModel(it.player.id ,competitionId, season, type)
        }
        val players = statsList.map {
            it.player.asDatabaseModel(it.statistics[0].team.id)
        }
        withContext(ioDispatcher) {
            database.topStatsDao.insertGoalData(*goalStats.toTypedArray())
            database.topStatsDao.insertPlayerData(*players.toTypedArray())
        }
    }
}