package com.ensegov.neofut.match_detail.data.remote.repository.events

import com.ensegov.neofut.match_detail.data.local.events.model.MatchEventData
import com.ensegov.neofut.match_detail.data.repository.events.EventsRepository
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

    override fun getEvents(id: Int): Flow<List<MatchEventData>> = events

    override suspend fun updateEvents(id: Int) {
        delay(300L)
        if (networkError)
            throw Exception()
        events.update { getFakeEventList(12) }
    }

    private fun getFakeEventList(count: Int) =
        List(count) {
            MatchEventData(
                matchId = 0,
                teamId = (1..2).random(),
                player = "player${(1..22).random()}",
                playerTwo = null,
                elapsedTime = (1..90).random(),
                type = "",
                detail = "",
            )
        }
}