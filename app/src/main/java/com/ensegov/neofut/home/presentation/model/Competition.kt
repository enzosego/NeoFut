package com.ensegov.neofut.home.presentation.model

import com.ensegov.neofut.home.data.remote.competition.dto.Country
import kotlinx.serialization.Serializable

@Serializable
data class Competition(
    val id: Int,
    val name: String,
    val type: String,
    val logoUrl: String,
    val country: Country,
    val seasons: List<Season>,
)

fun Competition.getLatestSeason() =
    seasons.maxOf { it.year }