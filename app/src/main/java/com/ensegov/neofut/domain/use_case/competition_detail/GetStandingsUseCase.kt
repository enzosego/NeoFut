package com.ensegov.neofut.domain.use_case.competition_detail

import com.ensegov.neofut.data.remote.standings.dto.TeamPosition
import com.ensegov.neofut.data.repository.CompetitionDetailRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class GetStandingsUseCase(
    private val competitionDetailRepository: CompetitionDetailRepository,
    private val ioDispatcher: CoroutineDispatcher
) {

    operator fun invoke(id: Int, season: Int): Flow<List<List<TeamPosition>>> {
        CoroutineScope(ioDispatcher).launch {
            competitionDetailRepository.getStandings(id, season)
        }
        return competitionDetailRepository.currentStandings
    }
}