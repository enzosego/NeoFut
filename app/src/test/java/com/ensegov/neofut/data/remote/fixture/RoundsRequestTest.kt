package com.ensegov.neofut.data.remote.fixture

import com.ensegov.neofut.data.remote.json.roundsResponseJson
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*

class RoundsRequestTest : StringSpec ({

    "Rounds request - retrieves correct number of rounds".config(blockingTest = true) {
        val mockEngine = MockEngine {
            respond(
                content = ByteReadChannel(roundsResponseJson),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val fixtureApi = FixtureApi(mockEngine, false)
        val roundList = fixtureApi.getRounds(0, 0).roundList

        roundList.size shouldBe 38
    }
})