package com.ensegov.neofut.match_detail.data.remote.fixture.dto.match

import com.ensegov.neofut.match_detail.data.local.fixture.MatchScoreData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AllMatchScoresDto(
    @SerialName(value = "halftime")
    val halfTime: MatchScoreDto,
    @SerialName(value = "fulltime")
    val fullTime: MatchScoreDto,
    @SerialName(value = "extratime")
    val extraTime: MatchScoreDto,
    val penalty: MatchScoreDto
)

/*
fun AllMatchScores.asDatabaseModel() = listOf(
    MatchScoreData
)
 */