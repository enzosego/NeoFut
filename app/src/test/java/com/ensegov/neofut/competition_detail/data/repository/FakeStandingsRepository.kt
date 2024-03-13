package com.ensegov.neofut.competition_detail.data.repository

import com.ensegov.neofut.competition_detail.createFakeGroups
import com.ensegov.neofut.competition_detail.data.repository.standings.StandingsRepository
import com.ensegov.neofut.competition_detail.presentation.standings.model.CompetitionGroup
import kotlinx.coroutines.delay

class FakeStandingsRepository(
    private val hasPersistedData: Boolean = false,
    private val canUpdate: Boolean = true,
    private val requestFailure: Boolean = false
) : StandingsRepository {

    override suspend fun updateStandings(id: Int, season: Int): List<CompetitionGroup> {
        delay(500L)
        if (requestFailure)
            throw Exception()
        else
            return createFakeGroups(5)
    }

    override suspend fun getStandings(id: Int, season: Int): List<CompetitionGroup> =
        if (hasPersistedData)
            createFakeGroups(groupCount = 3)
        else
            emptyList()

    override suspend fun canUpdateStandings(id: Int, season: Int): Boolean = canUpdate
}