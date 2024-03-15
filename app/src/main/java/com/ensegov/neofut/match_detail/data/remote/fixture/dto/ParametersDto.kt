package com.ensegov.neofut.match_detail.data.remote.fixture.dto

import kotlinx.serialization.Serializable

@Serializable
class ParametersDto(
    val league: Int,
    val season: Int,
    val round: String? = null
)