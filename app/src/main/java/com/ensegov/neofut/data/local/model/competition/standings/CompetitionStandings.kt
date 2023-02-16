package com.ensegov.neofut.data.local.model.competition.standings

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ensegov.neofut.data.remote.competition.dto.standings.Standings

@Entity(tableName = "competition_detail")
data class CompetitionStandings(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "standings_list")
    val standingsList: List<Standings>
)