package com.ensegov.neofut.competition_detail.data.remote.fixture.dto.match

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AllMatchScores(
    @SerialName(value = "halftime")
    val halfTime: MatchScore,
    @SerialName(value = "fulltime")
    val fullTime: MatchScore,
    @SerialName(value = "extratime")
    val extraTime: MatchScore,
    val penalty: MatchScore
)