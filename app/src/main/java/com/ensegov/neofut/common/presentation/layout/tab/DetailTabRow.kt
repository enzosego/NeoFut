@file:OptIn(ExperimentalFoundationApi::class)

package com.ensegov.neofut.common.presentation.layout.tab

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensegov.neofut.competition_detail.presentation.model.CompetitionDetailTab
import com.ensegov.neofut.match_detail.presentation.tab.MatchDetailTab
import com.ensegov.neofut.ui.theme.NeoFutTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun DetailTabRow(
    tabs: () -> List<DetailTab>,
    scope: () -> CoroutineScope,
    pagerState: () -> PagerState,
    selectedTabIndex: () -> Int,
    modifier: Modifier = Modifier
) {
    TabRow(
        selectedTabIndex = selectedTabIndex(),
        modifier = modifier.fillMaxWidth()
    ) {
        tabs().forEachIndexed { index, tab ->
            Tab(
                selected = selectedTabIndex() == index,
                selectedContentColor = MaterialTheme.colorScheme.primary,
                unselectedContentColor = MaterialTheme.colorScheme.outline,
                onClick = {
                    scope().launch {
                        pagerState().animateScrollToPage(page = index)
                    }
                }
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = tab.title)
                    Icon(
                        imageVector = if (index == selectedTabIndex())
                            tab.selectedIcon
                        else
                            tab.unselectedIcon,
                        contentDescription = null,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun CompetitionDetailTabRowPreview() {
    val pagerState = rememberPagerState(pageCount = { 1 })
    val tabs = listOf(
        CompetitionDetailTab.Fixture(),
        CompetitionDetailTab.Standings(hasCoverage = true),
        CompetitionDetailTab.Goals(hasCoverage = true),
        CompetitionDetailTab.Assists(hasCoverage = true)
    )
    NeoFutTheme {
        DetailTabRow(
            tabs = { tabs },
            scope = { CoroutineScope(Dispatchers.Main) },
            pagerState = { pagerState },
            selectedTabIndex = { 1 })
    }
}

@Preview
@Composable
private fun MatchDetailTabRowPreview() {
    val pagerState = rememberPagerState(pageCount = { 1 })
    val tabs = listOf(
        MatchDetailTab.Info(hasCoverage = true),
        MatchDetailTab.Lineups(hasCoverage = true),
        MatchDetailTab.Stats(hasCoverage = true)
    )
    NeoFutTheme {
        DetailTabRow(
            tabs = { tabs },
            scope = { CoroutineScope(Dispatchers.Main) },
            pagerState = { pagerState },
            selectedTabIndex = { 2 })
    }
}