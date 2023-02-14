package com.ensegov.neofut.data.remote.competition.dto

import kotlinx.serialization.Serializable

@Serializable
data class Season(
    val startDate: String,
    val endDate: String,
    val currentMatchday: Int
)