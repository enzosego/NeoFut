package com.ensegov.neofut.competition_detail.repository.goals

import com.ensegov.neofut.competition_detail.data.local.goals.TopScorerData
import com.ensegov.neofut.competition_detail.presentation.goals.model.TopScorerUiData

interface TopScorersRepository {

    suspend fun getTopScorers(competitionId: Int, season: Int): List<TopScorerUiData>

    suspend fun updateTopScorers(competitionId: Int, season: Int): List<TopScorerUiData>
}