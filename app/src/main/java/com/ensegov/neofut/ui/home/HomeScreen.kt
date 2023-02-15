package com.ensegov.neofut.ui.home

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.ensegov.neofut.data.remote.competition.dto.Competition
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()) {

    val competitionList: List<Competition> by viewModel.competitionList.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(
            text = "Available Competitions:",
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 25.dp)
        )
        LazyVerticalGrid(
            GridCells.Fixed(count = 2),
            content = {
                items(competitionList.size) { i ->
                    CompetitionLogo(competitionList[i])
                }
            },
            modifier = Modifier.padding(top = 50.dp)
        )
    }
}

@Composable
fun CompetitionLogo(competition: Competition) {

    val context = LocalContext.current

    AsyncImage(
        model = getImageModel(competition.emblem, context),
        contentDescription = null,
        modifier = Modifier
            .clickable { showMessage(context, competition.name) }
            .fillMaxSize()
    )
}

private fun showMessage(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

private fun getImageModel(url: String, context: Context): Any =
    if (url.takeLast(3) == "svg")
        ImageRequest.Builder(context)
            .data(url)
            .decoderFactory(SvgDecoder.Factory())
            .build()
    else
        url