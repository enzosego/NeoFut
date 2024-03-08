package com.ensegov.neofut.update_times.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import io.ktor.util.date.getTimeMillis

@Entity(
    tableName = "update_time",
    primaryKeys = ["type", "competition_id", "season", "round_name"]
)
data class UpdateTimeData(
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "competition_id")
    val competitionId: Int,
    @ColumnInfo(name = "season")
    val season: Int,
    @ColumnInfo(name = "round_name")
    val roundName: String = "",
    @ColumnInfo(name = "time")
    val time: Long
)

fun UpdateTimeData.getTimeDiffInHours(): Long =
    (((getTimeMillis() - time) / 1000) / 60) / 60

fun UpdateTimeData.getTimeDiffInDays(): Long =
    ((((getTimeMillis() - time) / 1000) / 60) / 60) / 24