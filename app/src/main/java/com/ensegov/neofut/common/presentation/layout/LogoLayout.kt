package com.ensegov.neofut.common.presentation.layout

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ensegov.neofut.R

@Composable
fun LogoLayout(
    logoUrl: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    AsyncImage(
        model = ImageRequest.Builder(context)
            .data(logoUrl)
            .crossfade(true)
            .build(),
        contentDescription = stringResource(R.string.team_logo),
        error = painterResource(R.drawable.ic_broken_image),
        placeholder = painterResource(R.drawable.loading_img),
        modifier = modifier
    )
}

@Preview
@Composable
private fun LogoLayoutPreview() {
    LogoLayout(logoUrl = "")
}