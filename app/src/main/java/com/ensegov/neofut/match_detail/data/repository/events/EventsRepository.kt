package com.ensegov.neofut.match_detail.data.repository.events

import com.ensegov.neofut.match_detail.data.local.events.model.MatchEventData
import kotlinx.coroutines.flow.Flow

interface EventsRepository {

    fun getEvents(id: Int): Flow<List<MatchEventData>>

    suspend fun updateEvents(id: Int)
}