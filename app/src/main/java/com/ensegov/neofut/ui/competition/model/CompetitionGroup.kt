package com.ensegov.neofut.ui.competition.model

data class CompetitionGroup(
    val groupName: String,
    val teamList: List<PositionUiData>
)