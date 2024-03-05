package com.ensegov.neofut.competition_detail.repository.goals

import com.ensegov.neofut.NeoFutDatabase
import com.ensegov.neofut.competition_detail.data.local.goals.asUiModel
import com.ensegov.neofut.competition_detail.data.remote.goals.TopScorersApi
import com.ensegov.neofut.competition_detail.data.remote.goals.dto.asDatabaseModel
import com.ensegov.neofut.competition_detail.data.remote.goals.dto.asUiModel
import com.ensegov.neofut.competition_detail.data.remote.player.asDatabaseModel
import com.ensegov.neofut.competition_detail.presentation.goals.model.TopScorerUiData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class TopScorersRepositoryImpl(
    private val database: NeoFutDatabase,
    private val topScorersApi: TopScorersApi,
    private val ioDispatcher: CoroutineDispatcher
) : TopScorersRepository {

    override suspend fun getTopScorers(
        competitionId: Int, season: Int
    ): List<TopScorerUiData> =
        withContext(ioDispatcher) {
            database.topScorerDao.getTopScorers(competitionId, season)
                .groupBy { it.goals.totalGoals }
                .toList()
                .flatMapIndexed { index, (_, list) ->
                    list.map { scorer ->
                        scorer.asUiModel(position = index + 1)
                    }
                }
                .sortedWith(
                    compareByDescending<TopScorerUiData> { it.totalGoals }.thenBy { it.penaltyGoals }
                )
        }

    override suspend fun updateTopScorers(
        competitionId: Int, season: Int
    ): List<TopScorerUiData> {
        val response = topScorersApi.getTopScorers(competitionId, season).response
        val goalStats = response.map {
            it.statistics[0].asDatabaseModel(it.player.id ,competitionId, season)
        }
        val players = response.map {
            it.player.asDatabaseModel(it.statistics[0].team.id)
        }
        withContext(ioDispatcher) {
            database.topScorerDao.insertGoalData(*goalStats.toTypedArray())
            database.topScorerDao.insertPlayerData(*players.toTypedArray())
        }
        return response
            .groupBy { it.statistics[0].goals.total }
            .toList()
            .flatMapIndexed { index, (_, list) ->
                list.map { scorer ->
                    scorer.asUiModel(position = index + 1)
                }
            }
            .sortedWith(
                compareByDescending<TopScorerUiData> { it.totalGoals }.thenBy { it.penaltyGoals }
            )
    }
}