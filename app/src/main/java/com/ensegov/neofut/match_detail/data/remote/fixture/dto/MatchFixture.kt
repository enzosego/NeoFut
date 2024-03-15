package com.ensegov.neofut.match_detail.data.remote.fixture.dto

import com.ensegov.neofut.match_detail.data.local.fixture.MatchData
import com.ensegov.neofut.match_detail.data.local.fixture.SimpleMatchFixture
import com.ensegov.neofut.match_detail.data.remote.fixture.dto.match.AllMatchScores
import com.ensegov.neofut.match_detail.data.remote.fixture.dto.match.MatchInfo
import com.ensegov.neofut.match_detail.data.remote.fixture.dto.match.MatchScoreDto
import com.ensegov.neofut.match_detail.data.remote.fixture.dto.match.MatchTeams
import com.ensegov.neofut.competition_detail.data.remote.team.asDatabaseModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

@Serializable
data class MatchFixture(
    @SerialName(value = "fixture")
    val info: MatchInfo,
    val teams: MatchTeams?,
    @SerialName(value = "goals")
    val currentScore: MatchScoreDto?,
    val score: AllMatchScores?
)

fun MatchFixture.asDatabaseModel(competitionId: Int, season: Int, round: String) =
    if (teams == null || currentScore == null)
        null
    else
        SimpleMatchFixture(
            data = MatchData(
                id = info.id,
                competitionId = competitionId,
                season = season,
                round = round,
                referee = info.referee,
                date = info.date.toTimeInMillis(),
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

private fun String.toTimeInMillis(
    dateFormat: String = "yyyy-MM-dd'T'HH:mm:ss",
    timeZone: TimeZone = TimeZone.getTimeZone("UTC")
): Long {
    val parser = SimpleDateFormat(dateFormat, Locale.getDefault())
    parser.timeZone = timeZone
    return parser.parse(this)!!.time
}