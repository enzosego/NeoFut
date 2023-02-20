package com.ensegov.neofut.domain.use_case.competition_detail

import com.ensegov.neofut.data.remote.standings.dto.TeamPosition
import com.ensegov.neofut.data.repository.CompetitionDetailRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class GetStandingsUseCase(
    private val competitionDetailRepository: CompetitionDetailRepository,
    private val ioDispatcher: CoroutineDispatcher
) {

    operator fun invoke(id: Int, season: Int): Flow<List<List<TeamPosition>>> =
        competitionDetailRepository.getStandings(id, season)
            .map {
                if (it == null)
                    CoroutineScope(ioDispatcher).launch {
                        competitionDetailRepository.updateStandings(id, season)
                    }
                it?.groupList ?: emptyList()
            }
}