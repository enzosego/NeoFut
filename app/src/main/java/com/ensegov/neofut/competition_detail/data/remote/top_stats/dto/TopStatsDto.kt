package com.ensegov.neofut.competition_detail.data.remote.top_stats.dto

import com.ensegov.neofut.competition_detail.data.local.top_stats.StatsData
import com.ensegov.neofut.competition_detail.data.remote.team.Team
import kotlinx.serialization.Serializable

@Serializable
data class TopStatsDto(
    val team: Team,
    val goals: PlayerGoalStats,
    val penalty: PenaltyStats
)

fun TopStatsDto.asDatabaseModel(playerId: Int, competitionId: Int, season: Int, type: String) =
    StatsData(
        playerId = playerId,
        teamId = team.id,
        season = season,
        competitionId = competitionId,
        type = type,
        totalGoals = goals.total ?: 0,
        penaltyGoals = penalty.scored ?: 0,
        assists = goals.assists ?: 0
    )