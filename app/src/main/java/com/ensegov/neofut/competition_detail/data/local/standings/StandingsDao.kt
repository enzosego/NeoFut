package com.ensegov.neofut.competition_detail.data.local.standings

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ensegov.neofut.competition_detail.presentation.standings.model.CompetitionGroup
import com.ensegov.neofut.competition_detail.data.local.team.TeamForm
import com.ensegov.neofut.competition_detail.data.local.team.TeamInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface StandingsDao {

    @Query("SELECT * FROM position " +
            "WHERE :id = position.competition_id AND :season = position.season " +
            "ORDER BY position.`group` ASC, position.position ASC")
    fun getStandings(id: Int, season: Int): List<TeamPositionInfo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPositions(vararg positionInfo: PositionInfo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeams(vararg teamInfo: TeamInfo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeamForms(vararg formInfo: TeamForm)
}

fun List<TeamPositionInfo>.asUiModel(): List<CompetitionGroup> =
    groupBy { (position, _) -> position.group }
        .map { (groupName, positionList) ->
            CompetitionGroup(
                groupName, positionList.map { it.asUiModel() }
            )
        }