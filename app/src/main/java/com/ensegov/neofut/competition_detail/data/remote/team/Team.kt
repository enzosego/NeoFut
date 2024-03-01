package com.ensegov.neofut.competition_detail.data.remote.team

import com.ensegov.neofut.competition_detail.data.local.team.TeamInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Team(
    val id: Int,
    val name: String,
    val code: String? = null,
    @SerialName(value = "logo")
    val logoUrl: String?,
    val founded: Int? = null,
    val winner: Boolean? = null
)

fun Team.asDatabaseModel() =
    TeamInfo(
        id = id,
        name = name,
        code = code,
        logoUrl = logoUrl,
        founded = founded
    )