package com.ensegov.neofut.competition_detail.data.remote.fixture

import com.ensegov.neofut.common.data.HttpRoutes
import com.ensegov.neofut.common.data.KtorClientApi
import com.ensegov.neofut.competition_detail.data.remote.fixture.dto.FixtureResponse
import com.ensegov.neofut.competition_detail.data.remote.fixture.dto.MatchFixture
import com.ensegov.neofut.competition_detail.data.remote.fixture.dto.SeasonRounds
import io.ktor.client.call.*
import io.ktor.client.engine.*

class FixtureApi(
    engine: HttpClientEngine,
    logging: Boolean = true
) : KtorClientApi(engine, logging, tag = "api_call_fixture") {

    suspend fun getRounds(leagueId: Int, season: Int): List<String> =
        request(
            url = "${HttpRoutes.FIXTURE_REQUEST}/rounds?league=$leagueId&season=$season"
        ).body<SeasonRounds>().response

    suspend fun getCurrentRound(leagueId: Int, season: Int): String =
        request(
            url = "${HttpRoutes.FIXTURE_REQUEST}/rounds?league=$leagueId&season=$season&current=true"
        ).body<SeasonRounds>().response.first()

    suspend fun getFixture(leagueId: Int, season: Int, round: String): List<MatchFixture> =
        request(
            url = "${HttpRoutes.FIXTURE_REQUEST}?league=$leagueId&season=$season&round=$round"
        ).body<FixtureResponse>().response
}