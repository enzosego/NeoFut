package com.ensegov.neofut.data.local.model.fixture

import androidx.room.Embedded
import androidx.room.Relation
import com.ensegov.neofut.data.local.model.competition.standings.TeamInfo
import com.ensegov.neofut.data.local.model.competition.standings.asShortUiModel
import com.ensegov.neofut.ui.competition.model.MatchUiShort

data class SimpleMatchFixture(
    @Embedded val data: MatchData,
    @Relation(
        parentColumn = "home_team_id",
        entityColumn = "id"
    )
    val homeTeam: TeamInfo,
    @Relation(
        parentColumn = "away_team_id",
        entityColumn = "id"
    )
    val awayTeam: TeamInfo,
)

fun SimpleMatchFixture.asShortUiModel() =
    MatchUiShort(
        data = data.asShortUiModel(),
        homeTeam = homeTeam.asShortUiModel(),
        awayTeam = awayTeam.asShortUiModel()
    )