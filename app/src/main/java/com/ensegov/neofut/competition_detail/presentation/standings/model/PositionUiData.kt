package com.ensegov.neofut.competition_detail.presentation.standings.model

import java.util.UUID

data class PositionUiData(
    val id: String = UUID.randomUUID().toString(),
    val team: String,
    val teamLogo: String,
    val position: Int,
    val points: Int,
    val goalsDiff: Int,
    val form: String?,
    val status: String?,
    val description: String?
)