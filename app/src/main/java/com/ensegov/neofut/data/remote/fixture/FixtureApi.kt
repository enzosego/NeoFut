package com.ensegov.neofut.data.remote.fixture

import com.ensegov.neofut.data.remote.fixture.dto.FixtureResponse
import com.ensegov.neofut.data.remote.fixture.dto.MatchDto
import com.ensegov.neofut.data.remote.fixture.dto.Rounds
import com.ensegov.neofut.data.remote.utils.HttpRoutes
import com.ensegov.neofut.data.remote.utils.KtorClientBuilder
import com.ensegov.neofut.data.remote.utils.getWithToken
import io.ktor.client.call.*
import io.ktor.client.engine.*

class FixtureApi(
    engine: HttpClientEngine,
    logging: Boolean = true
) {

    private val client = KtorClientBuilder(
        engine,
        logging,
        tag = "api_call_fixture"
    ).client

    suspend fun getRounds(leagueId: Int, season: Int): Rounds =
        client.getWithToken(
            "${HttpRoutes.FIXTURE_REQUEST}/rounds?league=$leagueId&season=$season"
        ).body()

    suspend fun getFixture(leagueId: Int, season: Int, round: String): List<MatchDto> =
        client.getWithToken(
            "${HttpRoutes.FIXTURE_REQUEST}?league=$leagueId&season=$season&round=$round"
        ).body<FixtureResponse>().fixture
}