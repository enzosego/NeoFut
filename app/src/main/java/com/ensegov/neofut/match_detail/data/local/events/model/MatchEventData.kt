package com.ensegov.neofut.match_detail.data.local.events.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "match_event",
    primaryKeys = ["match_id", "player", "elapsed_time", "detail"]
)
data class MatchEventData(
    @ColumnInfo(name = "match_id")
    val matchId: Int,
    @ColumnInfo(name = "team_id")
    val teamId: Int,
    @ColumnInfo(name = "player")
    val player: String,
    @ColumnInfo(name = "player_two")
    val playerTwo: String?,
    @ColumnInfo(name = "elapsed_time")
    val elapsedTime: Int,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "detail")
    val detail: String,
)
