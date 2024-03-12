package com.ensegov.neofut.competition_detail

import com.ensegov.neofut.competition_detail.presentation.standings.model.CompetitionGroup
import com.ensegov.neofut.competition_detail.presentation.standings.model.PositionUiData

internal fun createFakeList(groupCount: Int) =
    List(groupCount) {
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