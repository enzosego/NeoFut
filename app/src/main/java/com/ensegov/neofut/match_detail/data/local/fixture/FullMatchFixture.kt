package com.ensegov.neofut.match_detail.data.local.fixture

import androidx.room.Embedded
import androidx.room.Relation
import com.ensegov.neofut.competition_detail.data.local.team.TeamInfo
import com.ensegov.neofut.competition_detail.data.local.team.VenueData

data class FullMatchFixture(
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
    @Relation(
        parentColumn = "venue_id",
        entityColumn = "id"
    )
    val venue: VenueData?,
    @Relation(
        parentColumn = "id",
        entityColumn = "match_id"
    )
    val fullScoreData: List<MatchScoreData>
)