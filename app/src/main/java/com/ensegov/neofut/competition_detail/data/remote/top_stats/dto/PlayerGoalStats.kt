package com.ensegov.neofut.competition_detail.data.remote.top_stats.dto

import kotlinx.serialization.Serializable

@Serializable
data class PlayerGoalStats(
    val total: Int?,
    val conceded: Int?,
    val assists: Int?
)