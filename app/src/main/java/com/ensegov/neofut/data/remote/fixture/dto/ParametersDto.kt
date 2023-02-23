package com.ensegov.neofut.data.remote.fixture.dto

import kotlinx.serialization.Serializable

@Serializable
class ParametersDto(
    val league: Int,
    val season: Int,
    val round: String? = null
)