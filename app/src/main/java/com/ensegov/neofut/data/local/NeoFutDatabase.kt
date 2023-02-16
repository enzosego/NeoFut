package com.ensegov.neofut.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ensegov.neofut.data.local.converters.StandingsConverters
import com.ensegov.neofut.data.local.model.competition.standings.CompetitionStandings
import com.ensegov.neofut.data.local.model.competition.standings.CompetitionStandingsDao

@Database(
    entities = [CompetitionStandings::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(StandingsConverters::class)
abstract class NeoFutDatabase : RoomDatabase() {

    abstract val competitionStandingsDao: CompetitionStandingsDao
}