package com.ensegov.neofut.domain.use_case.competition_detail

import com.ensegov.neofut.data.local.model.fixture.asUiModel
import com.ensegov.neofut.data.repository.CompetitionDetailRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class GetSeasonFixtureUseCase(
    private val competitionDetailRepository: CompetitionDetailRepository,
    private val ioDispatcher: CoroutineDispatcher
) {

    operator fun invoke(id: Int, season: Int): Flow<List<String>> {
        val fixture = competitionDetailRepository.getSeasonFixture(id, season)
            .map { it?.asUiModel() ?: emptyList() }
        CoroutineScope(ioDispatcher).launch {
            if (fixture.first().isEmpty())
                competitionDetailRepository.updateSeasonFixture(id, season)
        }
        return fixture
    }
}