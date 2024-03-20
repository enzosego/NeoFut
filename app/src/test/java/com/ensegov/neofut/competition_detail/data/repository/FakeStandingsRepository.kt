package com.ensegov.neofut.competition_detail.data.repository

import com.ensegov.neofut.competition_detail.createFakeGroups
import com.ensegov.neofut.competition_detail.data.repository.standings.StandingsRepository
import com.ensegov.neofut.competition_detail.presentation.standings.model.CompetitionGroup
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class FakeStandingsRepository(
    hasPersistedData: Boolean = false,
    private val canUpdate: Boolean = true,
    private val requestFailure: Boolean = false
) : StandingsRepository {

    private val standings =
        if (hasPersistedData)
            createFakeGroups(count = 3)
        else
            emptyList()

    private val standingsFlow = MutableStateFlow(standings)

    override suspend fun updateStandings(id: Int, season: Int) {
        delay(300L)
        if (requestFailure)
            throw Exception()
        else
            standingsFlow.update { createFakeGroups(5) }
    }

    override fun getStandings(id: Int, season: Int): Flow<List<CompetitionGroup>> =
        standingsFlow

    override suspend fun canUpdateStandings(id: Int, season: Int): Boolean = canUpdate
}