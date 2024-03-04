package com.ensegov.neofut.competition_detail.data.local.goals

import androidx.room.Dao
import androidx.room.Query
import com.ensegov.neofut.competition_detail.data.local.team.TeamInfo
import com.ensegov.neofut.competition_detail.data.remote.team.Team

@Dao
interface TopScorerDao {

    @Query("SELECT * FROM goal_data " +
            "WHERE :competitionId = competition_id ")
    fun getTopScorers(competitionId: Int): List<TopScorerData>
}