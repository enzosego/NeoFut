package com.ensegov.neofut.competition_detail.presentation.standings.model

data class CompetitionGroup(
    val groupName: String,
    val teamList: List<PositionUiData>
)