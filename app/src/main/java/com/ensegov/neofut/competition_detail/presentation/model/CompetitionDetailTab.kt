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

sealed class CompetitionDetailTab(
    val hasCoverage: Boolean,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val title: String
) {
    class Fixture(
        hasCoverage: Boolean = true,
        selectedIcon: ImageVector = Icons.Filled.DateRange,
        unselectedIcon: ImageVector = Icons.Outlined.DateRange,
        title: String = "Fixture"
    ) : CompetitionDetailTab(hasCoverage, selectedIcon, unselectedIcon, title)
    class Standings(
        hasCoverage: Boolean,
        selectedIcon: ImageVector = Icons.Filled.TableChart,
        unselectedIcon: ImageVector = Icons.Outlined.TableChart,
        title: String = "Standings"
    ) : CompetitionDetailTab(hasCoverage, selectedIcon, unselectedIcon, title)
    class Goals(
        hasCoverage: Boolean,
        selectedIcon: ImageVector = Icons.Filled.SportsSoccer,
        unselectedIcon: ImageVector = Icons.Outlined.SportsSoccer,
        title: String = "Goals"
    ) : CompetitionDetailTab(hasCoverage, selectedIcon, unselectedIcon, title)
    class Assists(
        hasCoverage: Boolean,
        selectedIcon: ImageVector = Icons.Filled.WheelchairPickup,
        unselectedIcon: ImageVector = Icons.Outlined.WheelchairPickup,
        title: String = "Assists"
    ) : CompetitionDetailTab(hasCoverage, selectedIcon, unselectedIcon, title)
}