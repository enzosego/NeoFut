package com.ensegov.neofut.home.presentation.model

import com.ensegov.neofut.home.data.local.model.CoverageData
import kotlinx.serialization.Serializable

@Serializable
data class Season(
    val year: Int,
    val coverageData: Coverage
)