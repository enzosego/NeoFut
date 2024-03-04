package com.ensegov.neofut.competition_detail.presentation.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.TableChart
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.TableChart
import androidx.compose.ui.graphics.vector.ImageVector

enum class CompetitionDetailTab(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val title: String
) {
    Fixture(
        selectedIcon = Icons.Filled.DateRange,
        unselectedIcon = Icons.Outlined.DateRange,
        title = "Fixture"
    ),
    Standings(
        selectedIcon = Icons.Filled.TableChart,
        unselectedIcon = Icons.Outlined.TableChart,
        title = "Standings"
    )
}