package com.ensegov.neofut.data.local.model.competition.info

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ensegov.neofut.data.remote.competition.dto.Competition

@Entity(tableName = "competition_info")
data class CompetitionInfo(
    @PrimaryKey @ColumnInfo(name = "code")
    val code: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "emblem")
    val emblem: String,
)

fun CompetitionInfo.asDomainModel() =
    Competition(
        code,
        name,
        type,
        emblem
    )