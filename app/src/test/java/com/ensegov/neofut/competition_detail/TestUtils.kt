package com.ensegov.neofut.competition_detail

import com.ensegov.neofut.competition_detail.presentation.fixture.model.MatchDataShort
import com.ensegov.neofut.competition_detail.presentation.fixture.model.MatchDay
import com.ensegov.neofut.competition_detail.presentation.fixture.model.MatchUiShort
import com.ensegov.neofut.competition_detail.presentation.fixture.model.TeamInfoShort
import com.ensegov.neofut.competition_detail.presentation.standings.model.CompetitionGroup
import com.ensegov.neofut.competition_detail.presentation.standings.model.PositionUiData
import java.time.LocalDateTime

internal fun createFakeGroups(count: Int) =
    List(count) {
        CompetitionGroup(
            groupName = "Group $it",
            teamList = List(it) { index ->
                PositionUiData(
                    team = "team $index",
                    teamLogo = "",
                    position = index,
                    points = index * 2,
                    goalsDiff = index,
                    form = null,
                    status = null,
                    description = null
                )
            }
        )
    }

internal fun createFakeRoundFixture(count: Int) =
    List(count) {
        MatchDay(
            date = LocalDateTime.now(),
            matchList = List(count) { index ->
                MatchUiShort(
                    data = MatchDataShort(
                        id = index,
                        homeScore = index,
                        awayScore = index - 1,
                        status = "",
                        timeElapsed = 45
                    ),
                    time = LocalDateTime.now(),
                    homeTeam = TeamInfoShort(
                        name = "${(index + 1)}",
                        logoUrl = ""
                    ),
                    awayTeam = TeamInfoShort(
                        name = "${(index + 1) * 2}",
                        logoUrl = ""
                    )
                )
            }
        )
    }