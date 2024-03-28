package com.ensegov.neofut.match_detail.data.remote.repository.events

import com.ensegov.neofut.match_detail.data.repository.events.EventsRepository
import com.ensegov.neofut.match_detail.presentation.events.model.EventMoment
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class FakeEventsRepository(
    hasPersistedData: Boolean,
    private val networkError: Boolean
) : EventsRepository {

    private val events = MutableStateFlow(
        if (hasPersistedData)
            getFakeEventList(count = 7)
        else
            emptyList()
    )

    override suspend fun getEvents(id: Int): Flow<List<EventMoment>> = events

    override suspend fun updateEvents(id: Int) {
        delay(300L)
        if (networkError)
            throw Exception()
        events.update { getFakeEventList(12) }
    }

    private fun getFakeEventList(count: Int) =
        List(count) {
            EventMoment(
                time = 45,
                events = emptyList()
            )
        }
}