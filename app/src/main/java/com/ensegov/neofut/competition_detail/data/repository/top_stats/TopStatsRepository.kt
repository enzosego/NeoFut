package com.ensegov.neofut.competition_detail.data.repository.top_stats

import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerStatsUiData
import kotlinx.coroutines.flow.Flow

interface TopStatsRepository {

    fun getTopScorers(competitionId: Int, season: Int): Flow<List<PlayerStatsUiData>>

    suspend fun updateTopScorers(competitionId: Int, season: Int)

    fun getTopAssists(competitionId: Int, season: Int): Flow<List<PlayerStatsUiData>>

    suspend fun updateTopAssists(competitionId: Int, season: Int)

    suspend fun canUpdateTopStats(type: String, id: Int, season: Int): Boolean
}