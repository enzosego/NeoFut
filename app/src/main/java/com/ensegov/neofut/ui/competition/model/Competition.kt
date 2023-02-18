package com.ensegov.neofut.ui.competition.model

import com.ensegov.neofut.data.remote.competition.dto.Country
import com.ensegov.neofut.data.remote.competition.dto.season.Season
import kotlinx.serialization.Serializable

@Serializable
data class Competition(
    val id: Int,
    val name: String,
    val type: String,
    val logoUrl: String?,
    val country: Country,
    val seasons: List<Season>,
)

fun Competition.getLatestSeason() =
    seasons.maxOf { it.year }