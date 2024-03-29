package com.ensegov.neofut.match_detail.data.local.events.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.ensegov.neofut.match_detail.presentation.events.model.EventData
import com.ensegov.neofut.match_detail.presentation.events.model.EventType
import com.ensegov.neofut.match_detail.presentation.events.model.Locality

@Entity(
    tableName = "match_event",
    primaryKeys = ["match_id", "player", "elapsed_time", "detail"]
)
data class MatchEventData(
    @ColumnInfo(name = "match_id")
    val matchId: Int,
    @ColumnInfo(name = "team_id")
    val teamId: Int,
    @ColumnInfo(name = "player")
    val player: String,
    @ColumnInfo(name = "player_two")
    val playerTwo: String?,
    @ColumnInfo(name = "elapsed_time")
    val elapsedTime: Int,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "detail")
    val detail: String,
)

fun MatchEventData.asUiModel(teamIds: TeamIds) =
    EventData(
        locality = if (teamId == teamIds.home) Locality.HOME else Locality.AWAY,
        player = player,
        playerTwo = playerTwo,
        type = when (type) {
            "Goal" -> EventType.Goal(detail)
            "Card" -> EventType.Card(detail)
            "subst" -> EventType.Sub(detail)
            else -> EventType.Var(detail)
        }
    )
