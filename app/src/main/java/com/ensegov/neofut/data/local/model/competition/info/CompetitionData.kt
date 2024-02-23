package com.ensegov.neofut.data.local.model.competition.info

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ensegov.neofut.data.remote.competition.dto.Country
import com.ensegov.neofut.data.remote.competition.dto.season.Season
import com.ensegov.neofut.ui.competition.model.Competition

@Entity(tableName = "competition_data")
data class CompetitionData(
    @PrimaryKey @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "logo_url")
    val logoUrl: String?,
    @ColumnInfo(name = "country")
    val country: Country,
    @ColumnInfo(name = "emblem")
    val seasons: List<Season>,
)

fun CompetitionData.asDomainModel() =
    Competition(
        id, name, type, logoUrl, country, seasons
    )