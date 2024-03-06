package com.ensegov.neofut.competition_detail.data.remote.top_stats.dto

import kotlinx.serialization.Serializable

@Serializable
data class TopStatsResponse(
    val response: List<PlayerStatsDto>
)
