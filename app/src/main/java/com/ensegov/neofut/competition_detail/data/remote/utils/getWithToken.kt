package com.ensegov.neofut.competition_detail.data.remote.utils

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

suspend fun HttpClient.getWithToken(url: String): HttpResponse =
    get(url) {
        header("x-rapidapi-key", HttpRoutes.API_TOKEN)
        header("x-rapidapi-host", HttpRoutes.API_HOST)
    }