package com.ensegov.neofut.data.remote.competition

import com.ensegov.neofut.home.data.remote.competition.CompetitionsApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*

class CompetitionsApiTest : StringSpec({

    "Competitions request - should return eleven competitions" {
        val mockEngine = MockEngine {
            respond(
                content = ByteReadChannel(competitionListResponseJson),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val competitionsApi = CompetitionsApi(mockEngine, logging = false)
        val result = competitionsApi.getCountryCompetitions("argentina")

        result.size shouldBe 11
    }
})
