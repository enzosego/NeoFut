package com.ensegov.neofut.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ensegov.neofut.data.local.converters.RoomConverters
import com.ensegov.neofut.data.local.model.competition.info.CompetitionInfo
import com.ensegov.neofut.data.local.model.competition.info.CompetitionInfoDao
import com.ensegov.neofut.data.local.model.competition.standings.CompetitionStandings
import com.ensegov.neofut.data.local.model.competition.standings.CompetitionStandingsDao

@Database(
    entities = [CompetitionStandings::class, CompetitionInfo::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(RoomConverters::class)
abstract class NeoFutDatabase : RoomDatabase() {

    abstract val competitionStandingsDao: CompetitionStandingsDao
    abstract val competitionInfoDao: CompetitionInfoDao
}