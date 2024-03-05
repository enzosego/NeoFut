package com.ensegov.neofut.competition_detail.data.remote.goals.dto

import com.ensegov.neofut.competition_detail.data.remote.player.PlayerDto
import com.ensegov.neofut.competition_detail.data.remote.player.asUiModel
import com.ensegov.neofut.competition_detail.presentation.goals.model.TopScorerUiData
import kotlinx.serialization.Serializable

@Serializable
data class TopScorerDto(
    val player: PlayerDto,
    val statistics: List<GoalStatisticsDto>
)

fun TopScorerDto.asUiModel(position: Int) =
    TopScorerUiData(
        player = player.asUiModel(),
        position = position,
        totalGoals = statistics[0].goals.total ?: 0,
        penaltyGoals = statistics[0].penalty.scored ?: 0,
        teamName = statistics[0].team.name,
        teamLogoUrl = statistics[0].team.logoUrl ?: ""
    )