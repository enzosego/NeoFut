package com.ensegov.neofut.competition_detail.data.repository.top_stats

import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerStatsUiData

interface TopStatsRepository {

    suspend fun getTopScorers(competitionId: Int, season: Int): List<PlayerStatsUiData>

    suspend fun getTopScorersFromNetwork(competitionId: Int, season: Int): List<PlayerStatsUiData>

    suspend fun getTopAssists(competitionId: Int, season: Int): List<PlayerStatsUiData>

    suspend fun getTopAssistsFromNetwork(competitionId: Int, season: Int): List<PlayerStatsUiData>
}