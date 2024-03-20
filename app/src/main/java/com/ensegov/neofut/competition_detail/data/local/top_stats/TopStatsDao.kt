package com.ensegov.neofut.competition_detail.data.local.top_stats

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.ensegov.neofut.competition_detail.data.local.player.PlayerData
import kotlinx.coroutines.flow.Flow

@Dao
interface TopStatsDao {

    @Transaction
    @Query("SELECT * FROM player_stats " +
            "WHERE :competitionId = competition_id AND season = :season AND type = 'goals'")
    fun getTopScorers(competitionId: Int, season: Int): Flow<List<TopStatsData>>

    @Transaction
    @Query("SELECT * FROM player_stats " +
            "WHERE :competitionId = competition_id AND season = :season AND type = 'assists'")
    fun getTopAssists(competitionId: Int, season: Int): Flow<List<TopStatsData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStatsData(statList: List<StatsData>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlayerData(playerList: List<PlayerData>)

    @Transaction
    suspend fun insertStatsAndPlayerData(statList: List<StatsData>, playerList: List<PlayerData>) {
        insertStatsData(statList)
        insertPlayerData(playerList)
    }
}