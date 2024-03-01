package com.ensegov.neofut.home.data.remote.competition.dto.season

import com.ensegov.neofut.home.data.local.model.SeasonData
import kotlinx.serialization.Serializable

@Serializable
data class Season(
    val year: Int,
    val start: String,
    val end: String,
    val current: Boolean,
)

fun Season.asDatabaseModel(competitionId: Int) =
    SeasonData(
        competitionId = competitionId,
        year = year,
        start = start,
        end = end,
        current = current
    )