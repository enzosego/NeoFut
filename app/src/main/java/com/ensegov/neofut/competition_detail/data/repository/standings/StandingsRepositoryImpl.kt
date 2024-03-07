package com.ensegov.neofut.competition_detail.data.repository.standings

import com.ensegov.neofut.NeoFutDatabase
import com.ensegov.neofut.competition_detail.data.local.standings.asUiModel
import com.ensegov.neofut.competition_detail.data.remote.standings.StandingsApi
import com.ensegov.neofut.competition_detail.data.remote.standings.dto.asDatabaseModel
import com.ensegov.neofut.competition_detail.data.remote.standings.dto.asUiModel
import com.ensegov.neofut.competition_detail.data.remote.team.asDatabaseModel
import com.ensegov.neofut.competition_detail.presentation.standings.model.CompetitionGroup
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class StandingsRepositoryImpl(
    private val database: NeoFutDatabase,
    private val standingsApi: StandingsApi,
    private val ioDispatcher: CoroutineDispatcher
) : StandingsRepository {

    override suspend fun updateStandings(id: Int, season: Int): List<CompetitionGroup> {
        val response = standingsApi.getCurrentStandings(id, season)

        val positions = response.map { list ->
            list.map {
                it.asDatabaseModel(id, season)
            }
        }.flatten()
        val teams = response.map { list ->
            list.map {
                it.team.asDatabaseModel()
            }
        }.flatten()
        val teamForms = response.map { list ->
            list.map {
                listOf(
                    it.allMatches.asDatabaseModel(variation = "all", it.team.id, id),
                    it.homeMatches.asDatabaseModel(variation = "home", it.team.id, id),
                    it.awayMatches.asDatabaseModel(variation = "away", it.team.id, id)
                )
            }
        }.flatten().flatten()

        withContext(ioDispatcher) {
            database.standingsDao.insertPositions(*positions.toTypedArray())
            database.standingsDao.insertTeams(*teams.toTypedArray())
            database.standingsDao.insertTeamForms(*teamForms.toTypedArray())
        }
        return response.map { list ->
            CompetitionGroup(
                groupName = list[0].group,
                teamList = list.map { it.asUiModel() }
            )
        }
    }

    override suspend fun getStandings(id: Int, season: Int): List<CompetitionGroup> =
        withContext(ioDispatcher) {
            database.standingsDao.getStandings(id, season).asUiModel()
        }
}