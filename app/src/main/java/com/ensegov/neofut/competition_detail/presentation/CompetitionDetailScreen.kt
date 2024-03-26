package com.ensegov.neofut.competition_detail.presentation

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
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.ensegov.neofut.competition_detail.presentation.fixture.FixtureLayout
import com.ensegov.neofut.home.presentation.model.Competition
import com.ensegov.neofut.competition_detail.presentation.model.CompetitionDetailTab
import com.ensegov.neofut.competition_detail.presentation.player_stats.TopStatsLayout
import com.ensegov.neofut.home.presentation.model.getLatestSeason
import com.ensegov.neofut.competition_detail.presentation.standings.StandingsLayout
import com.ensegov.neofut.common.presentation.layout.tab.DetailTabRow
import com.ensegov.neofut.home.presentation.model.toTabList
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Destination
@Composable
fun CompetitionDetailScreen(
    competition: Competition,
    navigator: DestinationsNavigator
) {

    val scope = rememberCoroutineScope()
    val tabs = remember {
        competition.seasons.find { 
            it.year == competition.getLatestSeason()
        }?.coverageData?.toTabList()
            ?.filter { it.hasCoverage }
            ?: emptyList()
    }
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val selectedTabIndex = remember { derivedStateOf { pagerState.currentPage } }

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = competition.name) }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingValues.calculateTopPadding())
        ) {
            DetailTabRow(
                tabs = { tabs },
                scope = { scope },
                pagerState = { pagerState },
                selectedTabIndex = { selectedTabIndex.value }
            )
            HorizontalPager(
                state = pagerState,
                key = { tabs[it].title },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                when (tabs[it]) {
                    is CompetitionDetailTab.Fixture -> FixtureLayout(
                        competitionId = competition.id,
                        competitionSeason = competition.getLatestSeason(),
                        navigator = navigator
                    )
                    is CompetitionDetailTab.Standings -> StandingsLayout(
                        competitionId = competition.id,
                        competitionSeason = competition.getLatestSeason()
                    )
                    is CompetitionDetailTab.Goals -> TopStatsLayout(
                        type = "goals",
                        competitionId = competition.id,
                        competitionSeason = competition.getLatestSeason()
                    )
                    is CompetitionDetailTab.Assists -> TopStatsLayout(
                        type = "assists",
                        competitionId = competition.id,
                        competitionSeason = competition.getLatestSeason()
                    )
                }
            }
        }
    }
}