package com.ensegov.neofut.competition_detail.presentation.fixture.model

import androidx.compose.runtime.Immutable
import java.time.LocalDateTime

@Immutable
data class MatchUiShort(
    val data: MatchDataShort,
    val time: LocalDateTime,
    val homeTeam: TeamInfoShort,
    val awayTeam: TeamInfoShort
)

fun generateFakeMatch(
    index: Int,
    count: Int,
    status: String = "LIVE"
) =
    MatchUiShort(
        data = MatchDataShort(
            id = (index + 1) * (index.. 100000).random(),
            homeScore = (0..4).random(),
            awayScore = (0..4).random(),
            status = status,
            timeElapsed = 48
        ),
        time = LocalDateTime.now(),
        homeTeam = TeamInfoShort(
            name = "Team ${index + 1}",
            logoUrl = ""
        ),
        awayTeam = TeamInfoShort(
            name = "Team ${count + index + 1}",
            logoUrl = ""
        )
    )