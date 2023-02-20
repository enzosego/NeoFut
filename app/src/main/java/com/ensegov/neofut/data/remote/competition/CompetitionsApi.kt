package com.ensegov.neofut.data.remote.competition

import com.ensegov.neofut.data.remote.competition.dto.AllCompetitions
import com.ensegov.neofut.data.remote.competition.dto.CompetitionDto
import com.ensegov.neofut.data.remote.utils.HttpRoutes
import com.ensegov.neofut.data.remote.utils.KtorClientBuilder
import com.ensegov.neofut.data.remote.utils.getWithToken
import io.ktor.client.call.*
import io.ktor.client.engine.*

class CompetitionsApi(
    engine: HttpClientEngine,
    logging: Boolean = true
) {

    private val client = KtorClientBuilder(
        engine,
        logging,
        tag = "api_call_competitions"
    ).client

    suspend fun getCountryCompetitions(countryName: String): List<CompetitionDto> =
        client.getWithToken(
            "${HttpRoutes.COMPETITION_REQUEST}?country=$countryName&current=true"
        ).body<AllCompetitions>().list
}