package com.ensegov.neofut.competition_detail.presentation.tab

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
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensegov.neofut.competition_detail.presentation.model.CompetitionDetailTab
import com.ensegov.neofut.ui.theme.NeoFutTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailTabRow(
    tabs: () -> List<CompetitionDetailTab>,
    scope: () -> CoroutineScope,
    pagerState: () -> PagerState,
    selectedTabIndex: () -> State<Int>,
    modifier: Modifier = Modifier
) {
    TabRow(
        selectedTabIndex = selectedTabIndex().value,
        modifier = modifier.fillMaxWidth()
    ) {
        tabs().forEachIndexed { index, tab ->
            Tab(
                selected = selectedTabIndex().value == index,
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
                        imageVector = if (index == selectedTabIndex().value)
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

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
private fun DetailTabRowPreview() {
    val pagerState = rememberPagerState(pageCount = { 1 })
    val index = remember { mutableIntStateOf(1) }
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
            selectedTabIndex = { index })
    }
}