package com.ensegov.neofut.data.remote.fixture

import com.ensegov.neofut.competition_detail.data.remote.fixture.FixtureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*

class RoundsRequestTest : StringSpec ({

    lateinit var result: List<String>

    val getResult: suspend (json: String) -> Unit =  { json ->
        val mockEngine = MockEngine {
            respond(
                content = ByteReadChannel(json),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val fixtureApi = FixtureApi(mockEngine, false)
        result = fixtureApi.getRounds(0, 0).roundList
    }

    "League rounds request - should have 38 total".config(blockingTest = true) {
        getResult(leagueRoundsResponseJson)

        result.size shouldBe 38
    }

    "Cup rounds request - should have 54 total".config(blockingTest = true) {
        getResult(cupRoundsResponseJson)

        result.size shouldBe 54
    }

    "Cup rounds request - should contain round of 16".config(blockingTest = true) {
        getResult(cupRoundsResponseJson)

        result shouldContain("Round of 16")
    }
})