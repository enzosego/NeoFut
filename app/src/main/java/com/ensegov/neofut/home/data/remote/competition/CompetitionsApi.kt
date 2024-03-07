package com.ensegov.neofut.home.data.remote.competition

import com.ensegov.neofut.home.data.remote.competition.dto.CompetitionsResponse
import com.ensegov.neofut.home.data.remote.competition.dto.CompetitionDto
import com.ensegov.neofut.common.data.HttpRoutes
import com.ensegov.neofut.common.data.KtorClientApi
import io.ktor.client.call.*
import io.ktor.client.engine.*

class CompetitionsApi(
    engine: HttpClientEngine,
    logging: Boolean = true
) : KtorClientApi(engine, logging, tag = "api_call_competitions") {

    suspend fun getCountryCompetitions(countryName: String): List<CompetitionDto> =
        request(
            "${HttpRoutes.COMPETITION_REQUEST}?country=$countryName&current=true"
        ).body<CompetitionsResponse>().response
}