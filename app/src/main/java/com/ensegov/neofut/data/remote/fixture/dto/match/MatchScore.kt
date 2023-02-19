package com.ensegov.neofut.data.remote.fixture.dto.match

import kotlinx.serialization.Serializable

@Serializable
data class MatchScore(
    val home: Int?,
    val away: Int?
)