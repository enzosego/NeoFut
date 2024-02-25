package com.ensegov.neofut.data.local.model.competition.standings

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ensegov.neofut.data.remote.team.dto.Team

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
    val founded: Int? = null,
    @ColumnInfo(name = "winner")
    val winner: Boolean? = null
)

fun TeamInfo.asUiModel() =
    Team(
        id = id,
        name = name,
        code = code,
        logoUrl = logoUrl,
        founded = founded,
        winner = winner
    )