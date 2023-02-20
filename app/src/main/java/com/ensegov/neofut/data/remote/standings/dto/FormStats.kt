package com.ensegov.neofut.data.remote.standings.dto

import kotlinx.serialization.Serializable

@Serializable
data class FormStats(
    val played: Int,
    val win: Int,
    val draw: Int,
    val lose: Int,
    val goals: GoalStats? = null
)