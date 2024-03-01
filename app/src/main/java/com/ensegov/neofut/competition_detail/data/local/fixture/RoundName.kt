package com.ensegov.neofut.competition_detail.data.local.fixture

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "round")
data class RoundName(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "competition_id")
    val competitionId: Int,
    @ColumnInfo(name = "season")
    val season: Int,
    @ColumnInfo(name = "name")
    val name: String
)
