package com.ensegov.neofut.match_detail.data.remote.events.dto

import com.ensegov.neofut.competition_detail.data.remote.player.PlayerDto
import com.ensegov.neofut.competition_detail.data.remote.team.Team
import kotlinx.serialization.Serializable

@Serializable
data class EventDto(
    val time: EventTimeDto,
    val team: Team,
    val player: PlayerEventDto,
    val assist: PlayerEventDto,
    val type: String,
    val detail: String
)