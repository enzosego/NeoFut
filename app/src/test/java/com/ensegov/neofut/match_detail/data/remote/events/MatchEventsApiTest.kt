package com.ensegov.neofut.match_detail.data.remote.events

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf

class MatchEventsApiTest : StringSpec({

    coroutineTestScope = true

    val mockEngine = MockEngine {
        respond(
            content = matchEventsResponseJson,
            status = HttpStatusCode.OK,
            headers = headersOf(HttpHeaders.ContentType, value = "application/json")
        )
    }

    "MatchEventsApi request - get the correct response" {
        val matchEventsApi = MatchEventsApi(engine = mockEngine, logging = false)
        val result = matchEventsApi.getEvents(fixtureId = 1032)

        result.size shouldBe 18
        result[0].type shouldBe "Goal"
        result[0].player.id shouldBe 6126
        result[0].time.elapsed shouldBe 25
    }
})