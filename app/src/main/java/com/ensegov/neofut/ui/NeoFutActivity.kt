package com.ensegov.neofut.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ensegov.neofut.ui.theme.NeoFutTheme
import com.ramcosta.composedestinations.DestinationsNavHost

class NeoFutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NeoFutTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}