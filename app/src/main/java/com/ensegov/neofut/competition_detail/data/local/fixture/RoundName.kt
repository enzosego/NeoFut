package com.ensegov.neofut.competition_detail.data.local.fixture

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "round",
    primaryKeys = ["competition_id", "season", "name", "index"]
)
data class RoundName(
    @ColumnInfo(name = "index")
    val index: Int,
    @ColumnInfo(name = "competition_id")
    val competitionId: Int,
    @ColumnInfo(name = "season")
    val season: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "current")
    val current: Boolean = false
)
