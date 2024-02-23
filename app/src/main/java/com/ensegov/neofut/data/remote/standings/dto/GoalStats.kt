package com.ensegov.neofut.data.remote.standings.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GoalStats(
    @SerialName(value = "for")
    val scored: Int?,
    val against: Int?
)
