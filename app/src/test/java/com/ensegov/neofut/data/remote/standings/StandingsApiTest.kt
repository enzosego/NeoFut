package com.ensegov.neofut.data.remote.standings

import com.ensegov.neofut.data.remote.json.cupStandingsResponseJson
import com.ensegov.neofut.data.remote.json.leagueStandingsResponseJson
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.serialization.json.JsonNull.content

class StandingsApiTest : StringSpec({

    lateinit var result: List<List<TeamPosition>>

    val getResult: suspend (json: String) -> Unit =  { json ->
        val engine = MockEngine {
            respond(
                content = ByteReadChannel(json),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val standingApi = StandingsApi(engine, logging = false)

        result = standingApi.getCurrentStandings(0, 0)
            .responseItem[0]
            .competitionStandingsDto
            .groupList
    }

    "Cup request - should have eight groups".config(blockingTest = true) {
        getResult(cupStandingsResponseJson)

        result.size shouldBe 8
    }

    "League request - should have many teams per group".config(blockingTest = true) {
        getResult(leagueStandingsResponseJson)

        result[1].size shouldBe 28
    }
})
