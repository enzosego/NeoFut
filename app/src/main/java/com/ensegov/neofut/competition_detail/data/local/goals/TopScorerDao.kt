package com.ensegov.neofut.competition_detail.data.local.goals

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.ensegov.neofut.competition_detail.data.local.player.PlayerData

@Dao
interface TopScorerDao {

    @Transaction
    @Query("SELECT * FROM goal_data " +
            "WHERE :competitionId = competition_id AND season = :season " +
            "ORDER BY total_goals DESC")
    fun getTopScorers(competitionId: Int, season: Int): List<TopScorerData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGoalData(vararg goalData: GoalData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlayerData(vararg playerData: PlayerData)
}