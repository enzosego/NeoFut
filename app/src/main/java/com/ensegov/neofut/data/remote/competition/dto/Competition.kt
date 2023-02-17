package com.ensegov.neofut.data.remote.competition.dto

import com.ensegov.neofut.data.local.model.competition.info.CompetitionInfo
import kotlinx.serialization.Serializable

@Serializable
data class Competition(
    val code: String,
    val name: String,
    val type: String,
    val emblem: String
)

fun Competition.asDatabaseModel() =
    CompetitionInfo(
        code,
        name,
        type,
        emblem
    )