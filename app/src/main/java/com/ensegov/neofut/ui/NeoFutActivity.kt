package com.ensegov.neofut.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.data.remote.competition.dto.standings.TeamPosition
import com.ensegov.neofut.ui.theme.NeoFutTheme
import org.koin.androidx.compose.koinViewModel

class NeoFutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NeoFutTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    League()
                }
            }
        }
    }
}

@Composable
fun League(viewModel: MainViewModel = koinViewModel()) {

    val leagueName: String by viewModel.competitionName.collectAsState()

    val teamList: List<TeamPosition> by viewModel.standings.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = leagueName,
            color = Color.Blue,
            fontSize = 30.sp
        )
        LazyColumn(
            Modifier
                .padding(20.dp)
        ) {
            items(teamList.size) { i ->
                TeamRow(teamList[i])
            }
        }
    }
}

@Composable
fun TeamRow(team: TeamPosition) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 12.dp)
    ) {
        Text(
            text = "${team.position}",
            fontSize = 23.sp,
            modifier = Modifier
                .width(30.dp),
        )
        Text(
            text = team.team.shortName,
            fontSize = 23.sp,
            modifier = Modifier
                .width(200.dp)
                .padding(start = 8.dp)
        )
        Text(
            text = "${team.points}",
            fontSize = 23.sp,
            modifier = Modifier
                .padding(start = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NeoFutTheme {
        League()
    }
}