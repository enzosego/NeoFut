package com.ensegov.neofut.competition_detail.data.local.player

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player")
data class PlayerData(
    @PrimaryKey @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "team_id")
    val teamId: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "first_name")
    val firstName: String,
    @ColumnInfo(name = "last_name")
    val lastName: String,
    @ColumnInfo(name = "age")
    val age: Int,
    @ColumnInfo(name = "nationality")
    val nationality: String,
    @ColumnInfo(name = "photo_url")
    val photoUrl: String
)