package com.ensegov.neofut.competition_detail.data.remote.goals.dto

import kotlinx.serialization.Serializable

@Serializable
class PenaltyStats(
    val scored: Int?,
    val missed: Int?
)