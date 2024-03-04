package com.ensegov.neofut.competition_detail.data.remote.goals.dto

import kotlinx.serialization.Serializable

@Serializable
data class PlayerGoalStats(
    val total: Int,
    val conceded: Int
)