package com.ensegov.neofut.data.remote.team

import com.ensegov.neofut.data.remote.team.dto.TeamResponse
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.utils.io.ByteReadChannel

class TeamsApiTest : StringSpec({

    lateinit var result: List<TeamResponse>

    val getResult: suspend (String) -> Unit = { json ->
        val mockEngine = MockEngine {
            respond(
                content = ByteReadChannel(json),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }

        val teamsApi = TeamsApi(mockEngine, logging = false)
        result = teamsApi.getTeam(0)
    }

    "Should retrieve correct information".config(blockingTest = true) {
        getResult(teamResponseJson)

        result.size shouldBe 1
        with(result[0]) {
            team.name shouldBe "River Plate"
            team.code shouldBe "RIV"
            venue.name shouldBe "Estadio Monumental Antonio Vespucio Liberti"
            venue.capacity shouldBe 65645
        }
    }
})