package com.ensegov.neofut.competition_detail.data.local.goals

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class PlayerGoalsData(
    @ColumnInfo(name = "id")
    val id: Int,
)