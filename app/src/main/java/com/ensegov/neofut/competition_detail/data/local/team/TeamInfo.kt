package com.ensegov.neofut.competition_detail.data.local.team

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ensegov.neofut.competition_detail.presentation.fixture.model.TeamInfoShort

@Entity(tableName = "team")
data class TeamInfo(
    @PrimaryKey @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "code")
    val code: String? = null,
    @ColumnInfo(name = "logo_url")
    val logoUrl: String?,
    @ColumnInfo(name = "founded")
    val founded: Int? = null
)

fun TeamInfo.asShortUiModel() =
    TeamInfoShort(
        name = name,
        logoUrl = logoUrl ?: ""
    )