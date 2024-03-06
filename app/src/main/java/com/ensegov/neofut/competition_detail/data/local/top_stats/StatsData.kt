package com.ensegov.neofut.competition_detail.data.local.top_stats

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "player_stats",
    primaryKeys = ["player_id", "team_id", "competition_id", "season", "type"]
)
data class StatsData(
    @ColumnInfo(name = "player_id")
    val playerId: Int,
    @ColumnInfo(name = "team_id")
    val teamId: Int,
    @ColumnInfo(name = "competition_id")
    val competitionId: Int,
    @ColumnInfo(name = "season")
    val season: Int,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "total_goals")
    val totalGoals: Int,
    @ColumnInfo(name = "penalty_goals")
    val penaltyGoals: Int,
    @ColumnInfo(name = "assists")
    val assists: Int
)
