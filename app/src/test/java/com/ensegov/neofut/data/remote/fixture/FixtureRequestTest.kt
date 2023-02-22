package com.ensegov.neofut.data.remote.fixture

import com.ensegov.neofut.data.remote.fixture.dto.MatchFixture
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*

class FixtureRequestTest : StringSpec({

    lateinit var result: List<MatchFixture>

    val getResult: suspend (json: String) -> Unit =  { json ->
        val mockEngine = MockEngine {
            respond(
                content = ByteReadChannel(json),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }

        val fixtureApi = FixtureApi(mockEngine, logging = false)
        result = fixtureApi.getFixture(0, 0, "")
   }

    "League - should contain ten matches".config(blockingTest = true) {
        getResult(leagueFixtureResponseJson)

        result.size shouldBe 10
    }

    "League - away team won by two".config(blockingTest = true) {
        getResult(leagueFixtureResponseJson)

        with(result[0]) {
            teams.home.winner shouldBe false
            teams.away.winner shouldBe true
            currentScore.home shouldBe 0
            currentScore.away shouldBe 2
        }
    }

    "Cup round of 16 - should contain 16 matches".config(blockingTest = true) {
        getResult(cupFixtureResponseJson)

        result.size shouldBe 16
    }

    "Cup round of 16 - to be played - should not have a winner".config(blockingTest = true) {
        getResult(cupFixtureResponseJson)

        with(result[8]) {
            info.status.long shouldBe "Not Started"
            teams.home.winner shouldBe null
            teams.away.winner shouldBe null
            currentScore.home shouldBe null
            currentScore.away shouldBe null
        }
    }

    "Cup round of 16 - past result - should have a winner".config(blockingTest = true) {
        getResult(cupFixtureResponseJson)

        with(result[0]) {
            info.status.long shouldBe "Match Finished"
            teams.home.winner shouldBe true
            teams.away.winner shouldBe false
            currentScore.home shouldBe 1
            currentScore.away shouldBe 0
        }
    }
})