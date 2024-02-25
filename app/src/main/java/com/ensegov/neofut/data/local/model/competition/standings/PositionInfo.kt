package com.ensegov.neofut.data.local.model.competition.standings

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ensegov.neofut.data.remote.team.dto.Team

@Entity(tableName = "position")
data class PositionInfo(
    @PrimaryKey @ColumnInfo(name = "team_id")
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