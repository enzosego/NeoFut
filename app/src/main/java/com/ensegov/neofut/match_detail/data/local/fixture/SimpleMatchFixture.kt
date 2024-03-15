package com.ensegov.neofut.match_detail.data.local.fixture

import androidx.room.Embedded
import androidx.room.Relation
import com.ensegov.neofut.competition_detail.data.local.team.TeamInfo
import com.ensegov.neofut.competition_detail.data.local.team.asShortUiModel
import com.ensegov.neofut.competition_detail.presentation.fixture.model.MatchUiShort

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