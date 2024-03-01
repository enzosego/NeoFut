package com.ensegov.neofut.home.data.remote.competition.dto

import com.ensegov.neofut.home.data.local.model.CompetitionData
import com.ensegov.neofut.home.data.remote.competition.dto.season.Season
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CompetitionDto(
    @SerialName(value = "league")
    val info: CompetitionInfo,
    val country: Country,
    val seasons: List<Season>
)

fun CompetitionDto.asDatabaseModel() =
    CompetitionData(
        info.id,
        info.name,
        info.type,
        info.logoUrl,
        country.name,
        country.code,
        country.flagUrl
    )