package com.ensegov.neofut.competition_detail.presentation.standings.model

data class PositionUiData(
    val team: String,
    val teamLogo: String,
    val position: Int,
    val points: Int,
    val goalsDiff: Int,
    val form: String?,
    val status: String?,
    val description: String?,
)