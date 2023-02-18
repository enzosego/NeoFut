package com.ensegov.neofut.data.remote.competition.dto.season

import kotlinx.serialization.Serializable

@Serializable
data class Season(
    val year: Int,
    val start: String,
    val end: String,
    val current: Boolean,
    val coverage: Coverage
)