package com.ensegov.neofut.data.remote.team

import com.ensegov.neofut.data.remote.team.dto.Team

interface TeamsApi {

    suspend fun getTeam(teamId: String): Team
}