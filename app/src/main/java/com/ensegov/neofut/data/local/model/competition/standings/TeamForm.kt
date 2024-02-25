package com.ensegov.neofut.data.local.model.competition.standings

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ensegov.neofut.data.remote.standings.dto.FormStats
import com.ensegov.neofut.data.remote.standings.dto.GoalStats

@Entity(tableName = "team_form")
data class TeamForm(
    @PrimaryKey @ColumnInfo(name = "team_id")
    val teamId: Int,
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