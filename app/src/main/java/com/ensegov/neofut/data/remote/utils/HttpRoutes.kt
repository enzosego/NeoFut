package com.ensegov.neofut.data.remote.utils

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

object HttpRoutes {

    const val API_TOKEN = "41c8afbbcc0e4894b8c6c8e1b87677b4"

    private const val BASE_URL = "https://api.football-data.org/v4"

    const val COMPETITION_REQUEST = "$BASE_URL/competitions/"

    const val TEAM_REQUEST = "$BASE_URL/teams/"
}

suspend fun HttpClient.getWithToken(urlString: String): HttpResponse =
    get(urlString) { header("X-Auth-Token", HttpRoutes.API_TOKEN) }