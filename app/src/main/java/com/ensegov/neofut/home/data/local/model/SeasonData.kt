package com.ensegov.neofut.home.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import com.ensegov.neofut.home.presentation.model.Season

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
    @Embedded
    val coverageData: CoverageData
)

fun SeasonData.asUiModel() =
    Season(
        year = year,
        coverageData = coverageData.asUiModel()
    )