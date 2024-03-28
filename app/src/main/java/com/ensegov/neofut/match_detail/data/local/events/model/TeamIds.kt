package com.ensegov.neofut.match_detail.data.local.events.model

import androidx.room.ColumnInfo

data class TeamIds(
    @ColumnInfo(name = "home_team_id")
    val home: Int,
    @ColumnInfo(name = "away_team_id")
    val away: Int
)
