package com.ensegov.neofut.home.data.remote.competition.dto.season

import com.ensegov.neofut.home.data.local.model.SeasonData
import com.ensegov.neofut.home.presentation.model.Season
import kotlinx.serialization.Serializable

@Serializable
data class SeasonDto(
    val year: Int,
    val start: String,
    val end: String,
    val current: Boolean,
    val coverage: CoverageDto
)

fun SeasonDto.asDatabaseModel(competitionId: Int) =
    SeasonData(
        competitionId = competitionId,
        year = year,
        start = start,
        end = end,
        current = current,
        coverageData = coverage.asDatabaseModel()
    )

fun SeasonDto.asUiModel() =
    Season(
        year = year,
        coverageData = coverage.asUiModel()
    )