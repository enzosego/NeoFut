package com.ensegov.neofut.data.remote.competition.dto

import kotlinx.serialization.Serializable

@Serializable
data class Competition(
    val name: String,
    val code: String,
    val type: String,
    val emblem: String
)