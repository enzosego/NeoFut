package com.ensegov.neofut.domain.use_case.competition_detail

import com.ensegov.neofut.data.remote.fixture.dto.MatchFixture
import com.ensegov.neofut.data.repository.CompetitionDetailRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class GetRoundFixtureUseCase(
    private val competitionDetailRepository: CompetitionDetailRepository,
    private val ioDispatcher: CoroutineDispatcher
) {

    operator fun invoke(id: Int, season: Int, round: String): Flow<List<MatchFixture>> {
        val roundFixture = competitionDetailRepository.getRoundFixture(id, season, round)
            .map { it?.matchList ?: emptyList() }
        CoroutineScope(ioDispatcher).launch {
            if (roundFixture.first().isEmpty())
                competitionDetailRepository.updateRoundFixture(id, season, round)
        }
        return roundFixture
    }
}