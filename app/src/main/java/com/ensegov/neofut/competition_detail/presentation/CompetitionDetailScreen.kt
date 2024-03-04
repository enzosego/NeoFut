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
import com.ensegov.neofut.competition_detail.presentation.model.Competition
import com.ensegov.neofut.competition_detail.presentation.model.CompetitionDetailTab
import com.ensegov.neofut.competition_detail.presentation.model.getLatestSeason
import com.ensegov.neofut.competition_detail.presentation.standings.StandingsLayout
import com.ensegov.neofut.competition_detail.presentation.tab.DetailTabRow
import com.ramcosta.composedestinations.annotation.Destination

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Destination
@Composable
fun CompetitionDetailScreen(competition: Competition) {

    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { CompetitionDetailTab.entries.size })
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
                scope = { scope },
                pagerState = { pagerState },
                selectedTabIndex = { selectedTabIndex }
            )
            HorizontalPager(
                state = pagerState,
                key = { CompetitionDetailTab.entries[it] },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                when (CompetitionDetailTab.entries[it]) {
                    CompetitionDetailTab.Fixture -> FixtureLayout(
                        competitionId = competition.id,
                        competitionSeason = competition.getLatestSeason()
                    )
                    CompetitionDetailTab.Standings -> StandingsLayout(
                        competitionId = competition.id,
                        competitionSeason = competition.getLatestSeason()
                    )
                }
            }
        }
    }
}