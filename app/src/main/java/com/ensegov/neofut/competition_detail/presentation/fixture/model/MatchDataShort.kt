package com.ensegov.neofut.competition_detail.presentation.fixture.model

data class MatchDataShort(
    val id: Int,
    val homeScore: Int,
    val awayScore: Int,
    val status: String,
    val timeElapsed: Int
)