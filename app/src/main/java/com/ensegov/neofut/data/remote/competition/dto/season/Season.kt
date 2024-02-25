package com.ensegov.neofut.data.remote.competition.dto.season

import com.ensegov.neofut.data.local.model.competition.info.SeasonData
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