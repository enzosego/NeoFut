package com.ensegov.neofut.data.local.model.fixture

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fixture_data")
data class FixtureData(
    @PrimaryKey @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "round_list")
    val totalRounds: Int,
    @ColumnInfo(name = "season")
    val season: Int
)