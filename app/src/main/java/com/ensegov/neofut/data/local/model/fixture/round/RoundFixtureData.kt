package com.ensegov.neofut.data.local.model.fixture.round

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ensegov.neofut.data.remote.fixture.dto.MatchFixture

@Entity(
    tableName = "round_fixture",
    primaryKeys = ["id", "season", "round"]
)
data class RoundFixtureData(
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "season")
    val season: Int,
    @ColumnInfo(name = "round")
    val round: String,
    @ColumnInfo(name = "match_list")
    val matchList: List<MatchFixture>
)