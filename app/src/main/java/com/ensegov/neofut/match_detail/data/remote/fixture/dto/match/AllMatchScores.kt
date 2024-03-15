package com.ensegov.neofut.match_detail.data.remote.fixture.dto.match

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AllMatchScores(
    @SerialName(value = "halftime")
    val halfTime: MatchScoreDto,
    @SerialName(value = "fulltime")
    val fullTime: MatchScoreDto,
    @SerialName(value = "extratime")
    val extraTime: MatchScoreDto,
    val penalty: MatchScoreDto
)