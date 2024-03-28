package com.ensegov.neofut.match_detail.presentation.events.model

import androidx.compose.runtime.Immutable

@Immutable
data class EventData(
    val locality: Locality,
    val type: EventType,
    val player: String,
    val playerTwo: String?
)