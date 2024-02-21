package com.ensegov.neofut.data.remote.team

import com.ensegov.neofut.data.remote.team.dto.AllTeamsResponse
import com.ensegov.neofut.data.remote.team.dto.TeamResponse
import com.ensegov.neofut.data.remote.utils.HttpRoutes
import com.ensegov.neofut.data.remote.utils.KtorClientBuilder
import com.ensegov.neofut.data.remote.utils.getWithToken
import io.ktor.client.call.*
import io.ktor.client.engine.*

class TeamsApi(
    engine: HttpClientEngine,
    logging: Boolean
) {

    private val client = KtorClientBuilder(
        engine,
        logging
    ).client

    suspend fun getTeam(teamId: Int): List<TeamResponse> =
        client.getWithToken("${HttpRoutes.TEAM_REQUEST}/$teamId")
            .body<AllTeamsResponse>().teamList
}