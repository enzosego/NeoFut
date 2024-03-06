package com.ensegov.neofut.competition_detail.data.local.top_stats

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.ensegov.neofut.competition_detail.data.local.player.PlayerData

@Dao
interface TopStatsDao {

    @Transaction
    @Query("SELECT * FROM player_stats " +
            "WHERE :competitionId = competition_id AND season = :season AND type = 'goals'")
    fun getTopScorers(competitionId: Int, season: Int): List<TopStatsData>

    @Transaction
    @Query("SELECT * FROM player_stats " +
            "WHERE :competitionId = competition_id AND season = :season AND type = 'assists'")
    fun getTopAssists(competitionId: Int, season: Int): List<TopStatsData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGoalData(vararg goalData: StatsData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlayerData(vararg playerData: PlayerData)
}