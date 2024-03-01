package com.ensegov.neofut.competition_detail.data.local.standings

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "position",
    primaryKeys = ["team_id", "competition_id", "season"]
)
data class PositionInfo(
    @ColumnInfo(name = "team_id")
    val teamId: Int,
    @ColumnInfo(name = "competition_id")
    val competitionId: Int,
    @ColumnInfo(name = "season")
    val season: Int,
    @ColumnInfo(name = "position")
    val position: Int,
    @ColumnInfo(name = "points")
    val points: Int,
    @ColumnInfo(name = "goals_diff")
    val goalsDiff: Int,
    @ColumnInfo(name = "group")
    val group: String,
    @ColumnInfo(name = "form")
    val form: String?,
    @ColumnInfo(name = "status")
    val status: String?,
    @ColumnInfo(name = "description")
    val description: String?,
)