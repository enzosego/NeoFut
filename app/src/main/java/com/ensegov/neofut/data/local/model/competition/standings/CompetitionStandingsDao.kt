package com.ensegov.neofut.data.local.model.competition.standings

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface CompetitionStandingsDao {

    @Query("SELECT * FROM competition_detail " +
            "WHERE :id = id")
    fun getStandings(id: String): Flow<CompetitionStandings?>

    @Query("SELECT * FROM competition_detail")
    fun getAll(): Flow<List<CompetitionStandings>>

    @Upsert
    fun insertOrUpdate(competitionStandings: CompetitionStandings)
}