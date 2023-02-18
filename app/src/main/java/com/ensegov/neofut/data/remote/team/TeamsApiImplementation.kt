package com.ensegov.neofut.data.remote.team

import com.ensegov.neofut.data.remote.team.dto.Team
import com.ensegov.neofut.data.remote.utils.HttpRoutes
import com.ensegov.neofut.data.remote.utils.KtorClientBuilder
import com.ensegov.neofut.data.remote.utils.getWithToken
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class TeamsApiImplementation(
    private val client: HttpClient
) : TeamsApi {

    override suspend fun getTeam(teamId: String): Team =
        client.getWithToken(teamId)
            .body()

    companion object {
        fun create(): TeamsApi =
            TeamsApiImplementation(
                KtorClientBuilder(
                    isLoggingEnabled = true,
                    tag = "competition_api_call"
                ).client
            )
    }
}