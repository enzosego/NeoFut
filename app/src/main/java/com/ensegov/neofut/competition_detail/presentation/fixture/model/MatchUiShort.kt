package com.ensegov.neofut.competition_detail.presentation.fixture.model

data class MatchUiShort(
    val data: MatchDataShort,
    val homeTeam: TeamInfoShort,
    val awayTeam: TeamInfoShort
)

fun generateFakeMatch(index: Int, count: Int) =
    MatchUiShort(
        data = MatchDataShort(
            id = index,
            homeScore = 2,
            awayScore = 1,
            status = "",
            timeElapsed = 48
        ),
        homeTeam = TeamInfoShort(
            name = "Team $index",
            logoUrl = ""
        ),
        awayTeam = TeamInfoShort(
            name = "Team ${count - index}",
            logoUrl = ""
        )
    )