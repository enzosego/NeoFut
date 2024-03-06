package com.ensegov.neofut.competition_detail.presentation.player_stats.model

data class PlayerStatsUiData(
    val player: PlayerUiData,
    val position: Int,
    val totalGoals: Int,
    val penaltyGoals: Int,
    val assists: Int,
    val teamName: String,
    val teamLogoUrl: String
)
