package com.ensegov.neofut.data.local.model.fixture.season

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fixture_data")
data class SeasonFixtureData(
    @PrimaryKey @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "season")
    val season: Int,
    @ColumnInfo(name = "round_list")
    val roundList: List<String>
)

fun SeasonFixtureData.asUiModel() =
    roundList