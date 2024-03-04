package com.ensegov.neofut.competition_detail.data.remote.goals.dto

import com.ensegov.neofut.competition_detail.data.remote.team.Team
import kotlinx.serialization.Serializable

@Serializable
data class StatisticsDto(
    val team: Team,
    val goals: PlayerGoalStats,
    val penalty: PenaltyStats
)