package com.ensegov.neofut.data.remote.fixture

import com.ensegov.neofut.data.remote.fixture.dto.MatchDto
import com.ensegov.neofut.data.remote.json.fixtureResponseJson
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*

class FixtureRequestTest : StringSpec({

    lateinit var result: List<MatchDto>

    beforeEach {
        val mockEngine = MockEngine {
            respond(
                content = ByteReadChannel(fixtureResponseJson),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val fixtureApi = FixtureApi(mockEngine, logging = false)
        result = fixtureApi.getFixture(0, 0, "")
    }

    "Result - Gets all matches".config(blockingTest = true) {
        result.size shouldBe 10
    }

    "Result - Has the correct score".config(blockingTest = true) {
        result[0].currentScore.home shouldBe 0
        result[0].currentScore.away shouldBe 2
    }
})