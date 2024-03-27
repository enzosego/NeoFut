package com.ensegov.neofut.match_detail.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ensegov.neofut.common.presentation.layout.tab.DetailTabRow
import com.ensegov.neofut.match_detail.presentation.events.EventsLayout
import com.ensegov.neofut.match_detail.presentation.tab.MatchDetailTab
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Destination
@Composable
fun MatchDetailScreen(
    matchId: Int
) {

    val viewModel: MatchDetailViewModel = koinViewModel(
        parameters = { parametersOf(matchId) }
    )
    val matchDetail by viewModel.matchDetail.collectAsStateWithLifecycle()
    val tabs: List<MatchDetailTab> by viewModel.matchDetailTabs.collectAsStateWithLifecycle()
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val selectedTabIndex = remember { derivedStateOf { pagerState.currentPage } }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Match Detail") }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingValues.calculateTopPadding())
        ) {
            DetailTabRow(
                tabs = { tabs },
                scope = { coroutineScope },
                pagerState = { pagerState },
                selectedTabIndex = { selectedTabIndex.value })
            HorizontalPager(
                state = pagerState,
                key = { tabs[it].title },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                when (tabs[it]) {
                    is MatchDetailTab.Info -> EventsLayout(matchId)
                    is MatchDetailTab.Lineups -> Text(text = "Lineups")
                    is MatchDetailTab.Stats -> Text(text = "Match stats")
                }
            }
        }
    }
}