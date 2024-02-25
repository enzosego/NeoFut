package com.ensegov.neofut.data.local.model.competition.info

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ensegov.neofut.data.remote.competition.dto.Country
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
    @ColumnInfo(name = "country_name")
    val countryName: String,
    @ColumnInfo(name = "country_code")
    val countryCode: String? = null,
    @ColumnInfo(name = "country_flag_url")
    val countryFlagUrl: String? = null
)

fun CompetitionData.asUiModel(seasons: List<SeasonData>) =
    Competition(
        id,
        name,
        type,
        logoUrl,
        Country(
            countryName,
            countryCode,
            countryFlagUrl
        ),
        seasons.map { it.asUiModel() }
    )