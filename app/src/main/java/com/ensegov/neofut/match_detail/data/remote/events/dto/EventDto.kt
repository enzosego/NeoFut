package com.ensegov.neofut.match_detail.data.remote.events.dto

import com.ensegov.neofut.competition_detail.data.remote.team.Team
import com.ensegov.neofut.match_detail.data.local.events.model.MatchEventData
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

fun EventDto.asDatabaseModel(matchId: Int) =
    MatchEventData(
        matchId = matchId,
        teamId = team.id,
        player = player.name ?: "",
        playerTwo = assist.name,
        elapsedTime = time.elapsed + (time.extra ?: 0),
        type = type,
        detail = detail
    )