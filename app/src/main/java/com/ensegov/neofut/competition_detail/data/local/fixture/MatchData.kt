package com.ensegov.neofut.competition_detail.data.local.fixture

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ensegov.neofut.competition_detail.presentation.fixture.model.MatchDataShort

@Entity(tableName = "match_data")
data class MatchData(
    @PrimaryKey @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "competition_id")
    val competitionId: Int,
    @ColumnInfo(name = "season")
    val season: Int,
    @ColumnInfo(name = "round")
    val round: String,
    @ColumnInfo(name = "home_score")
    val homeScore: Int?,
    @ColumnInfo(name = "away_score")
    val awayScore: Int?,
    @ColumnInfo(name = "status_long")
    val statusLong: String,
    @ColumnInfo(name = "status_short")
    val statusShort: String,
    @ColumnInfo(name = "time_elapsed")
    val timeElapsed: Int?,
    @ColumnInfo(name = "home_team_id")
    val homeTeamId: Int,
    @ColumnInfo(name = "away_team_id")
    val awayTeamId: Int
)

fun MatchData.asShortUiModel() =
    MatchDataShort(
        id = id,
        homeScore = homeScore ?: 0,
        awayScore = awayScore ?: 0,
        status = statusShort,
        timeElapsed = timeElapsed ?: 0
    )