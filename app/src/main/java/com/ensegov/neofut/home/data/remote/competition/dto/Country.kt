package com.ensegov.neofut.home.data.remote.competition.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    val name: String,
    val code: String?,
    @SerialName("flag")
    val flagUrl: String?
)