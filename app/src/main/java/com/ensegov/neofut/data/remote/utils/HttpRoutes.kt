package com.ensegov.neofut.data.remote.utils

object HttpRoutes {

    const val API_TOKEN = "6837ac69b743b3072644b6f0c5057e97"

    const val API_HOST = "v3.football.api-sports.io"

    private const val BASE_URL = "https://v3.football.api-sports.io"

    const val COMPETITION_REQUEST = "$BASE_URL/leagues"

    const val FIXTURE_REQUEST = "$BASE_URL/fixtures"

    const val STANDINGS_REQUEST = "$BASE_URL/standings"

    const val TEAM_REQUEST = "$BASE_URL/teams"
}