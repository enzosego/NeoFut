package com.ensegov.neofut.competition_detail.data.remote.fixture.dto

import com.ensegov.neofut.competition_detail.data.local.fixture.MatchData
import com.ensegov.neofut.competition_detail.data.local.fixture.SimpleMatchFixture
import com.ensegov.neofut.competition_detail.data.remote.fixture.dto.match.AllMatchScores
import com.ensegov.neofut.competition_detail.data.remote.fixture.dto.match.MatchInfo
import com.ensegov.neofut.competition_detail.data.remote.fixture.dto.match.MatchScore
import com.ensegov.neofut.competition_detail.data.remote.fixture.dto.match.MatchTeams
import com.ensegov.neofut.competition_detail.data.remote.team.asDatabaseModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MatchFixture(
    @SerialName(value = "fixture")
    val info: MatchInfo,
    val teams: MatchTeams?,
    @SerialName(value = "goals")
    val currentScore: MatchScore?,
    val score: AllMatchScores?
)

fun MatchFixture.asDatabaseModel(competitionId: Int, season: Int, round: String) =
    if (teams == null || currentScore == null)
        null
    else
        SimpleMatchFixture(
            data = MatchData(
                info.id,
                competitionId,
                season,
                round,
                currentScore.home,
                currentScore.away,
                info.status.long,
                info.status.short,
                info.status.elapsed,
                teams.home.id,
                teams.away.id
            ),
            homeTeam = teams.home.asDatabaseModel(),
            awayTeam = teams.away.asDatabaseModel(),
        )