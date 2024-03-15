package com.ensegov.neofut.match_detail.data.local.fixture

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "match_score",
    primaryKeys = ["match_id", "score_type"]
)
data class MatchScoreData(
    @ColumnInfo(name = "match_id")
    val matchId: Int,
    @ColumnInfo(name = "score_type")
    val scoreType: String,
    @ColumnInfo(name = "home")
    val home: Int?,
    @ColumnInfo(name = "away")
    val away: Int?
)
