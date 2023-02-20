package com.ensegov.neofut.data.local.model.competition.standings

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface CompetitionStandingsDao {

    @Query("SELECT * FROM competition_standings " +
            "WHERE :id = id AND :season = season_num")
    fun getStandings(id: Int, season: Int): Flow<CompetitionStandings?>

    @Upsert
    fun upsert(competitionStandings: CompetitionStandings)
}