package com.ensegov.neofut.competition_detail.data.local.team

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.ensegov.neofut.competition_detail.data.remote.standings.dto.FormStats
import com.ensegov.neofut.competition_detail.data.remote.standings.dto.GoalStats

@Entity(
    tableName = "team_form",
    primaryKeys = ["team_id", "competition_id"]
)
data class TeamForm(
    @ColumnInfo(name = "team_id")
    val teamId: Int,
    @ColumnInfo(name = "competition_id")
    val competitionId: Int,
    @ColumnInfo(name = "variation")
    val variation: String,
    @ColumnInfo(name = "played")
    val played: Int?,
    @ColumnInfo(name = "win")
    val win: Int?,
    @ColumnInfo(name = "draw")
    val draw: Int?,
    @ColumnInfo(name = "lose")
    val lose: Int?,
    @ColumnInfo(name = "goals_for")
    val goalsScored: Int?,
    @ColumnInfo(name = "goals_against")
    val goalsAgainst: Int?
)

fun TeamForm.asUiModel(): FormStats =
    FormStats(
        played = played,
        win = win,
        draw = draw,
        lose = lose,
        goals = GoalStats(goalsScored, goalsAgainst)
    )