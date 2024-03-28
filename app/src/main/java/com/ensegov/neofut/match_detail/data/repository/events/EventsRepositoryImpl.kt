package com.ensegov.neofut.match_detail.data.repository.events

import android.util.Log
import com.ensegov.neofut.NeoFutDatabase
import com.ensegov.neofut.match_detail.data.local.events.model.asUiModel
import com.ensegov.neofut.match_detail.data.remote.events.MatchEventsApi
import com.ensegov.neofut.match_detail.data.remote.events.dto.asDatabaseModel
import com.ensegov.neofut.match_detail.presentation.events.model.EventMoment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class EventsRepositoryImpl(
    private val database: NeoFutDatabase,
    private val eventsApi: MatchEventsApi
) : EventsRepository {

    override suspend fun getEvents(id: Int): Flow<List<EventMoment>> = withContext(Dispatchers.IO) {
        database.eventsDao.getEvents(id)
            .map { data ->
                data.groupBy { it.elapsedTime }
                    .map { (time, list) ->
                        val teamIds = database.eventsDao.getTeamIds(id)
                        EventMoment(
                            time = time,
                            events = list.map { event -> event.asUiModel(teamIds) }
                        )
                    }
            }
    }

    override suspend fun updateEvents(id: Int) = withContext(Dispatchers.IO) {
        val events = eventsApi.getEvents(id)
            .map { it.asDatabaseModel(id) }
        database.eventsDao.insertEvents(events)
    }
}