package com.ensegov.neofut.competition_detail.data.remote.top_stats.dto

import kotlinx.serialization.Serializable

@Serializable
class PenaltyStats(
    val scored: Int?,
    val missed: Int?
)