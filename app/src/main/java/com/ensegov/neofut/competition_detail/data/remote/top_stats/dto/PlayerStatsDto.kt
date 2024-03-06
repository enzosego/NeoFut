package com.ensegov.neofut.competition_detail.data.remote.top_stats.dto

import com.ensegov.neofut.competition_detail.data.remote.player.PlayerDto
import com.ensegov.neofut.competition_detail.data.remote.player.asUiModel
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerStatsUiData
import kotlinx.serialization.Serializable

@Serializable
data class PlayerStatsDto(
    val player: PlayerDto,
    val statistics: List<TopStatsDto>
)

fun PlayerStatsDto.asUiModel(position: Int) =
    PlayerStatsUiData(
        player = player.asUiModel(),
        position = position,
        totalGoals = statistics[0].goals.total ?: 0,
        penaltyGoals = statistics[0].penalty.scored ?: 0,
        assists = statistics[0].goals.assists ?: 0,
        teamName = statistics[0].team.name,
        teamLogoUrl = statistics[0].team.logoUrl ?: "",
    )