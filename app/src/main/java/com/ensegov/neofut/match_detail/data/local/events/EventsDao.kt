package com.ensegov.neofut.match_detail.data.local.events

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ensegov.neofut.match_detail.data.local.events.model.MatchEventData
import kotlinx.coroutines.flow.Flow

@Dao
interface EventsDao {

    @Query("SELECT * FROM match_event " +
            "WHERE :id = match_id " +
            "ORDER BY elapsed_time DESC")
    fun getEvents(id: Int): Flow<List<MatchEventData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEvents(events: List<MatchEventData>)
}