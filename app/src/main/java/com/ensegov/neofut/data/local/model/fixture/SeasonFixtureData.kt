package com.ensegov.neofut.data.local.model.fixture

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ensegov.neofut.data.remote.fixture.dto.MatchFixture
import com.ensegov.neofut.ui.competition.model.Fixture

@Entity(tableName = "fixture_data")
data class FixtureData(
    @PrimaryKey @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "season")
    val season: Int,
    @ColumnInfo(name = "round_name")
    val roundName: String,
    @ColumnInfo(name = "round_list")
    val totalRounds: Int
)

fun FixtureData.asUiModel() {
    val matchList = mutableListOf<MatchFixture>()

    Fixture(

    )
}