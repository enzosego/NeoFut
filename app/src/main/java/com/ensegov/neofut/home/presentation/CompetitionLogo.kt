package com.ensegov.neofut.home.presentation

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.ensegov.neofut.competition_detail.presentation.model.Competition
import com.ensegov.neofut.destinations.CompetitionScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
internal fun CompetitionLogo(competition: Competition, navigator: DestinationsNavigator) {

    val context = LocalContext.current

    AsyncImage(
        model = getImageModel(competition.logoUrl, context),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                navigator.navigate(CompetitionScreenDestination(competition))
            }
    )
}

fun getImageModel(url: String, context: Context): Any =
    if (url.takeLast(3) == "svg")
        ImageRequest.Builder(context)
            .data(url)
            .decoderFactory(SvgDecoder.Factory())
            .build()
    else
        url