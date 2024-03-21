package com.ensegov.neofut.competition_detail.presentation.fixture.model

import java.time.LocalDateTime

data class MatchDay(
    val date: LocalDateTime,
    val matchList: List<MatchUiShort>
)
