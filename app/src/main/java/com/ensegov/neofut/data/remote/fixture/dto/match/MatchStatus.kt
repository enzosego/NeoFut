package com.ensegov.neofut.data.remote.fixture.dto.match

import kotlinx.serialization.Serializable

@Serializable
data class MatchStatus(
    val long: String,
    val short: String,
    val elapsed: Int
)