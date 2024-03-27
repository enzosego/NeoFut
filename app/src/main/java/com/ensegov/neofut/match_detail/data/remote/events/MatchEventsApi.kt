package com.ensegov.neofut.match_detail.data.remote.events

import com.ensegov.neofut.common.data.HttpRoutes
import com.ensegov.neofut.common.data.KtorClientApi
import com.ensegov.neofut.match_detail.data.remote.events.dto.EventDto
import com.ensegov.neofut.match_detail.data.remote.events.dto.MatchEventsDto
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngine

class MatchEventsApi(
    engine: HttpClientEngine,
    logging: Boolean = true
) : KtorClientApi(engine, logging) {

    suspend fun getEvents(fixtureId: Int): List<EventDto> =
        request(
            url = "${HttpRoutes.MATCH_EVENTS_REQUEST}$fixtureId"
        ).body<MatchEventsDto>().response
}