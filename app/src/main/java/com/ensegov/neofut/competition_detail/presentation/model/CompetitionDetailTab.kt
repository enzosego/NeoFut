package com.ensegov.neofut.competition_detail.presentation.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material.icons.filled.TableChart
import androidx.compose.material.icons.filled.WheelchairPickup
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.SportsSoccer
import androidx.compose.material.icons.outlined.TableChart
import androidx.compose.material.icons.outlined.WheelchairPickup
import androidx.compose.ui.graphics.vector.ImageVector
import com.ensegov.neofut.common.presentation.layout.tab.DetailTab

sealed class CompetitionDetailTab(
    hasCoverage: Boolean,
    selectedIcon: ImageVector,
    unselectedIcon: ImageVector,
    title: String
) : DetailTab(hasCoverage, selectedIcon, unselectedIcon, title) {
    class Fixture(hasCoverage: Boolean = true) : CompetitionDetailTab(
        hasCoverage = hasCoverage,
        selectedIcon = Icons.Filled.DateRange,
        unselectedIcon = Icons.Outlined.DateRange,
        title = "Fixture"
    )
    class Standings(hasCoverage: Boolean) : CompetitionDetailTab(
        hasCoverage = hasCoverage,
        selectedIcon = Icons.Filled.TableChart,
        unselectedIcon = Icons.Outlined.TableChart,
        title = "Standings"
    )
    class Goals(hasCoverage: Boolean) : CompetitionDetailTab(
        hasCoverage = hasCoverage,
        selectedIcon = Icons.Filled.SportsSoccer,
        unselectedIcon = Icons.Outlined.SportsSoccer,
        title = "Goals"
    )
    class Assists(hasCoverage: Boolean) : CompetitionDetailTab(
        hasCoverage = hasCoverage,
        selectedIcon = Icons.Filled.WheelchairPickup,
        unselectedIcon = Icons.Outlined.WheelchairPickup,
        title = "Assists"
    )
}