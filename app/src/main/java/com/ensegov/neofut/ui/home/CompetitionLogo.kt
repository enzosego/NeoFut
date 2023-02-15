package com.ensegov.neofut.ui.home

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.ensegov.neofut.data.remote.competition.dto.Competition
import com.ensegov.neofut.ui.destinations.CompetitionScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
internal fun CompetitionLogo(competition: Competition, navigator: DestinationsNavigator) {

    val context = LocalContext.current

    AsyncImage(
        model = getImageModel(competition.emblem, context),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                navigator.navigate(CompetitionScreenDestination(competition))
            }
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