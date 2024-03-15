package com.ensegov.neofut.match_detail.data.remote.fixture.dto.match

import com.ensegov.neofut.match_detail.data.local.fixture.MatchScoreData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AllScoresDto(
    @SerialName(value = "halftime")
    val halfTime: MatchScoreDto,
    @SerialName(value = "fulltime")
    val fullTime: MatchScoreDto,
    @SerialName(value = "extratime")
    val extraTime: MatchScoreDto,
    val penalty: MatchScoreDto
)

fun AllScoresDto.asDatabaseModel(matchId: Int) = listOf(
    MatchScoreData(
        matchId = matchId,
        scoreType = "half time",
        home = halfTime.home,
        away = halfTime.away
    ),
    MatchScoreData(
        matchId = matchId,
        scoreType = "full time",
        home = fullTime.home,
        away = fullTime.away
    ),
    MatchScoreData(
        matchId = matchId,
        scoreType = "extra time",
        home = extraTime.home,
        away = extraTime.away
    ),
    MatchScoreData(
        matchId = matchId,
        scoreType = "penalty",
        home = penalty.home,
        away = penalty.away
    )
)