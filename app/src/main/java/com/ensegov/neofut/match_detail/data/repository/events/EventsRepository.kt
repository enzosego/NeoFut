package com.ensegov.neofut.match_detail.data.repository.events

import com.ensegov.neofut.match_detail.presentation.events.model.EventMoment
import kotlinx.coroutines.flow.Flow

interface EventsRepository {

    suspend fun getEvents(id: Int): Flow<List<EventMoment>>

    suspend fun updateEvents(id: Int)
}