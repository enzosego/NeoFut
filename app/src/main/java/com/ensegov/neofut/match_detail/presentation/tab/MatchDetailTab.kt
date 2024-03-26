package com.ensegov.neofut.match_detail.presentation.tab

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PeopleAlt
import androidx.compose.material.icons.filled.TableChart
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.PeopleAlt
import androidx.compose.material.icons.outlined.TableChart
import androidx.compose.ui.graphics.vector.ImageVector
import com.ensegov.neofut.common.presentation.layout.tab.DetailTab

sealed class MatchDetailTab(
    hasCoverage: Boolean,
    selectedIcon: ImageVector,
    unselectedIcon: ImageVector,
    title: String
) : DetailTab(hasCoverage, selectedIcon, unselectedIcon, title) {
    class Lineups(hasCoverage: Boolean) : MatchDetailTab(
        hasCoverage = hasCoverage,
        selectedIcon = Icons.Filled.PeopleAlt,
        unselectedIcon = Icons.Outlined.PeopleAlt,
        title = "Lineups"
    )
    class Info(hasCoverage: Boolean) : MatchDetailTab(
        hasCoverage = hasCoverage,
        selectedIcon = Icons.Filled.Info,
        unselectedIcon = Icons.Outlined.Info,
        title = "Info"
    )
    class Stats(hasCoverage: Boolean) : MatchDetailTab(
        hasCoverage = hasCoverage,
        selectedIcon = Icons.Filled.TableChart,
        unselectedIcon = Icons.Outlined.TableChart,
        title = "Stats"
    )
}