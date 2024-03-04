package com.ensegov.neofut.competition_detail.data.remote.player

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