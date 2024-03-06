package com.ensegov.neofut.competition_detail.data.remote.player

import com.ensegov.neofut.competition_detail.data.local.player.PlayerData
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerUiData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayerDto(
    val id: Int,
    val name: String,
    @SerialName(value = "firstname")
    val firstName: String,
    @SerialName(value = "lastname")
    val lastName: String,
    val age: Int,
    val nationality: String,
    val photo: String
)

fun PlayerDto.asDatabaseModel(teamId: Int) =
    PlayerData(
        id = id,
        teamId = teamId,
        name = name,
        firstName = firstName,
        lastName = lastName,
        age = age,
        nationality = nationality,
        photoUrl = photo
    )

fun PlayerDto.asUiModel() =
    PlayerUiData(
        name = name,
        firstName = firstName,
        lastName = lastName,
        photoUrl = photo
    )