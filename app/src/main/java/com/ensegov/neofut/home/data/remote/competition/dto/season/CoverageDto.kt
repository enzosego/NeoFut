package com.ensegov.neofut.home.data.remote.competition.dto.season

import com.ensegov.neofut.home.data.local.model.CoverageData
import com.ensegov.neofut.home.presentation.model.Coverage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoverageDto(
    @SerialName(value = "fixtures")
    val fixtureCoverageDto: FixtureCoverageDto,
    val standings: Boolean,
    val players: Boolean,
    @SerialName(value = "top_scorers")
    val goals: Boolean,
    @SerialName(value = "top_assists")
    val assists: Boolean,
    val injuries: Boolean
)

fun CoverageDto.asDatabaseModel() =
    CoverageData(
        standings = standings,
        players = players,
        goals = goals,
        assists = assists,
        injuries = injuries,
        events = fixtureCoverageDto.events,
        statistics = fixtureCoverageDto.statisticsFixtures,
        lineups = fixtureCoverageDto.lineups
    )

fun CoverageDto.asUiModel() =
    Coverage(
        standings = standings,
        players = players,
        goals = goals,
        assists = assists,
        injuries = injuries,
        events = fixtureCoverageDto.events,
        lineups = fixtureCoverageDto.lineups
    )