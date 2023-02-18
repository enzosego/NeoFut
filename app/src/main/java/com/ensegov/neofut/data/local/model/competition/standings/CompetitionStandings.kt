package com.ensegov.neofut.data.local.model.competition.standings

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition

@Entity(tableName = "competition_standings")
data class CompetitionStandings(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "group_list")
    val groupList: List<List<TeamPosition>>
)