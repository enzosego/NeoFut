package com.ensegov.neofut.ui.competition.model

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