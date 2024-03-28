package com.ensegov.neofut.common.presentation

import androidx.lifecycle.ViewModel
import java.time.temporal.TemporalAccessor

fun TemporalAccessor.asUiModel() =
    toString()[0] + toString().substring(1).lowercase()

object StatusValues {

    val showScore = listOf(
        "LIVE",
        "1H",
        "HT",
        "2H",
        "BT",
        "ET",
        "FT",
        "P",
        "SUSP",
        "AET",
        "PEN",
        "INT"
    )

    val fullTime = listOf(
        "FT",
        "AET",
        "PEN"
    )

    val explicit = listOf(
        "HT",
        "P",
        "SUSP"
    )
}

fun ViewModel.tag() = this::class.simpleName