package com.ensegov.neofut.ui.competition.model

data class MatchDataShort(
    val id: Int,
    val homeScore: Int,
    val awayScore: Int,
    val status: String,
    val timeElapsed: Int
)