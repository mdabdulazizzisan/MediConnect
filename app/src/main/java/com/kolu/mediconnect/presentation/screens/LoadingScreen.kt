package com.kolu.mediconnect.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.kolu.mediconnect.presentation.lottie_animations.HeartAnimation

@Composable
fun LoadingScreen(modifier: Modifier = Modifier.fillMaxSize()) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        LinearProgressIndicator()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LoadingScreenPrev() {
    LoadingScreen()
}