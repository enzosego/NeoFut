package com.ensegov.neofut.data.local.model.competition.standings

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ensegov.neofut.data.remote.standings.dto.FormStats
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition
import kotlinx.coroutines.flow.Flow

@Dao
interface StandingsDao {

    @Query("SELECT * FROM position " +
            "JOIN team_form ON position.team_id = team_form.team_id " +
            "WHERE :id = position.competition_id AND :season = position.season " +
            "ORDER BY position.`group` ASC, position.position ASC")
    fun getStandings(id: Int, season: Int): Flow<Map<TeamPositionInfo, List<TeamForm>>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPositions(vararg positionInfo: PositionInfo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeams(vararg teamInfo: TeamInfo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeamForms(vararg formInfo: TeamForm)
}

fun Map<TeamPositionInfo, List<TeamForm>>.asUiModel(): List<List<TeamPosition>> {
    val groups = toList().groupBy { (position, _) -> position.positionInfo.group }
    return groups.map { (_, group) ->
        group.map { (pos, formList) ->
            val posInfo = pos.positionInfo

            val allForm = formList.find { it.variation == "all" }?.asUiModel() ?: emptyFormStats()
            val homeForm = formList.find { it.variation == "home" }?.asUiModel() ?: emptyFormStats()
            val awayForm = formList.find { it.variation == "away" }?.asUiModel() ?: emptyFormStats()

            TeamPosition(
                position = posInfo.position,
                team = pos.teamInfo.asUiModel(),
                points = posInfo.points,
                goalsDiff = posInfo.goalsDiff,
                group = posInfo.group,
                form = posInfo.form,
                status = posInfo.status,
                description = posInfo.description,
                allMatches = allForm,
                homeMatches = homeForm,
                awayMatches = awayForm,
            )
        }
    }
}

fun emptyFormStats() = FormStats(
    played = null,
    win = null,
    draw = null,
    lose = null
)