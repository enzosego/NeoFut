package com.ensegov.neofut.ui

import com.ramcosta.composedestinations.annotation.NavGraph

@NavGraph
annotation class NeoFutNavGraph(
    val start: Boolean = false,
    val default: Boolean = true
)