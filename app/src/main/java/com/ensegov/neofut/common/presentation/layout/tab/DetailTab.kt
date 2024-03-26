package com.ensegov.neofut.common.presentation.layout.tab

import androidx.compose.ui.graphics.vector.ImageVector

open class DetailTab(
    val hasCoverage: Boolean,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val title: String
)