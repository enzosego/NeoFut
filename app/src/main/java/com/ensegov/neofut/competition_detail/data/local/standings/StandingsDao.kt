package com.ensegov.neofut.competition_detail.data.local.standings

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.ensegov.neofut.competition_detail.presentation.standings.model.CompetitionGroup
import com.ensegov.neofut.competition_detail.data.local.team.TeamForm
import com.ensegov.neofut.competition_detail.data.local.team.TeamInfo

@Dao
interface StandingsDao {

    @Transaction
    @Query("SELECT * FROM position " +
            "WHERE :id = position.competition_id AND :season = position.season " +
            "ORDER BY position.`group` ASC, position.position ASC")
    fun getStandings(id: Int, season: Int): List<TeamPositionInfo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPositions(positions: List<PositionInfo>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeams(teams: List<TeamInfo>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeamForms(formList: List<TeamForm>)

    @Transaction
    suspend fun insertStandingsData(
        positions: List<PositionInfo>,
        teams: List<TeamInfo>,
        formList: List<TeamForm>
    ) {
        insertPositions(positions)
        insertTeams(teams)
        insertTeamForms(formList)
    }
}

fun List<TeamPositionInfo>.asUiModel(): List<CompetitionGroup> =
    groupBy { (position, _) -> position.group }
        .map { (groupName, positionList) ->
            CompetitionGroup(
                groupName, positionList.map { it.asUiModel() }
            )
        }