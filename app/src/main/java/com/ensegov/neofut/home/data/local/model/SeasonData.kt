package com.ensegov.neofut.home.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ensegov.neofut.home.data.remote.competition.dto.season.Season

@Entity(
    tableName = "season",
    primaryKeys = ["competition_id", "year"]
)
data class SeasonData(
    @ColumnInfo(name = "competition_id")
    val competitionId: Int,
    @ColumnInfo(name = "year")
    val year: Int,
    @ColumnInfo(name = "start")
    val start: String,
    @ColumnInfo(name = "end")
    val end: String,
    @ColumnInfo(name = "current")
    val current: Boolean,
)

fun SeasonData.asUiModel() =
    Season(
        year = year,
        start = start,
        end = end,
        current = current
    )