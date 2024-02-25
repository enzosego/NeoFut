package com.ensegov.neofut.data.remote.fixture.dto

import com.ensegov.neofut.data.local.model.fixture.MatchData
import com.ensegov.neofut.data.local.model.fixture.SimpleMatchFixture
import com.ensegov.neofut.data.remote.fixture.dto.match.AllMatchScores
import com.ensegov.neofut.data.remote.fixture.dto.match.MatchInfo
import com.ensegov.neofut.data.remote.fixture.dto.match.MatchScore
import com.ensegov.neofut.data.remote.fixture.dto.match.MatchTeams
import com.ensegov.neofut.data.remote.team.dto.asDatabaseModel
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