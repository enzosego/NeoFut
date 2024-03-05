package com.ensegov.neofut.competition_detail.presentation.goals.model

data class TopScorerUiData(
    val player: PlayerUiData,
    val position: Int,
    val totalGoals: Int,
    val penaltyGoals: Int,
    val teamName: String,
    val teamLogoUrl: String
)
