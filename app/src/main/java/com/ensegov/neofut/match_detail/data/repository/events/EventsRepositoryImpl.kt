package com.ensegov.neofut.match_detail.data.repository.events

import com.ensegov.neofut.NeoFutDatabase
import com.ensegov.neofut.match_detail.data.local.events.model.MatchEventData
import com.ensegov.neofut.match_detail.data.remote.events.MatchEventsApi
import com.ensegov.neofut.match_detail.data.remote.events.dto.asDatabaseModel
import kotlinx.coroutines.flow.Flow

class EventsRepositoryImpl(
    private val database: NeoFutDatabase,
    private val eventsApi: MatchEventsApi
) : EventsRepository {

    override fun getEvents(id: Int): Flow<List<MatchEventData>> =
        database.eventsDao.getEvents(id)

    override suspend fun updateEvents(id: Int) {
        val events = eventsApi.getEvents(id)
            .map { it.asDatabaseModel(id) }
        database.eventsDao.insertEvents(events)
    }
}