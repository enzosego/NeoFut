package com.ensegov.neofut.match_detail.data.remote.fixture.dto.match

import kotlinx.serialization.Serializable

@Serializable
data class MatchScoreDto(
    val home: Int?,
    val away: Int?
)