package com.ensegov.neofut.competition_detail.data.remote.goals.dto

import com.ensegov.neofut.competition_detail.data.remote.player.PlayerDto

data class TopScorersResponse(
    val player: PlayerDto,
    val statistics: GoalStatisticsDto
)
