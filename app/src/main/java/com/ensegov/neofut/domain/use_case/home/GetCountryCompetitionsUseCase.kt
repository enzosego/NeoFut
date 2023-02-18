package com.ensegov.neofut.domain.use_case.home

import com.ensegov.neofut.data.local.model.competition.info.asUiModel
import com.ensegov.neofut.data.repository.CompetitionsRepository
import com.ensegov.neofut.ui.competition.model.Competition
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class GetCountryCompetitionsUseCase(
    private val competitionsRepository: CompetitionsRepository,
    private val ioDispatcher: CoroutineDispatcher
) {

    operator fun invoke(): Flow<List<Competition>> {
        CoroutineScope(ioDispatcher).launch {
            competitionsRepository.getAllCompetitions()
        }
        return competitionsRepository.allCompetitions
            .map { list ->
                list.map { it.asUiModel() }
            }
    }
}