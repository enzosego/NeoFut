package com.ensegov.neofut.competition_detail.data.local.goals

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "goal_data",
    primaryKeys = ["player_id", "team_id", "competition_id", "season"]
)
data class GoalData(
    @ColumnInfo(name = "player_id")
    val playerId: Int,
    @ColumnInfo(name = "team_id")
    val teamId: Int,
    @ColumnInfo(name = "competition_id")
    val competitionId: Int,
    @ColumnInfo(name = "season")
    val season: Int,
    @ColumnInfo(name = "total_goals")
    val totalGoals: Int,
    @ColumnInfo(name = "penalty_goals")
    val penaltyGoals: Int,
)
