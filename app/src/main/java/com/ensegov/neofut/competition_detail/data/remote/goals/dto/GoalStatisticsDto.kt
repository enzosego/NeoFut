package com.ensegov.neofut.competition_detail.data.remote.goals.dto

import com.ensegov.neofut.competition_detail.data.local.goals.GoalData
import com.ensegov.neofut.competition_detail.data.remote.team.Team
import kotlinx.serialization.Serializable

@Serializable
data class GoalStatisticsDto(
    val team: Team,
    val goals: PlayerGoalStats,
    val penalty: PenaltyStats
)

fun GoalStatisticsDto.asDatabaseModel(playerId: Int, competitionId: Int, season: Int) =
    GoalData(
        playerId = playerId,
        teamId = team.id,
        season = season,
        competitionId = competitionId,
        totalGoals = goals.total ?: 0,
        penaltyGoals = penalty.scored ?: 0
    )