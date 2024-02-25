package com.ensegov.neofut.data.local.model.competition.info

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ensegov.neofut.data.remote.competition.dto.season.Season

@Entity(tableName = "season")
data class SeasonData(
    @PrimaryKey @ColumnInfo(name = "competition_id")
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