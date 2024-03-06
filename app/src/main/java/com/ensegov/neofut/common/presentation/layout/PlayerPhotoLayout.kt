package com.ensegov.neofut.common.presentation.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ensegov.neofut.R
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun PlayerPhotoLayout(
    photoUrl: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val fallbackPainter = rememberVectorPainter(Icons.Filled.AccountCircle)

    Box(
        modifier = modifier.clip(CircleShape)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(photoUrl)
                .crossfade(true)
                .build(),
            contentDescription = stringResource(R.string.player_photo),
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = BrushPainter(
                Brush.linearGradient(
                    listOf(
                        Color(0xFFFFFFFF),
                        Color(0xFFDDDDDD)
                    )
                )
            ),
            fallback = fallbackPainter,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
private fun PlayerPhotoLayoutPreview() {
    NeoFutTheme {
        PlayerPhotoLayout("")
    }
}