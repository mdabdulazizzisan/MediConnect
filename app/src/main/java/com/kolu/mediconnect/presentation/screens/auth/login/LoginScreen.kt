package com.kolu.mediconnect.presentation.screens.auth.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    val text by remember { mutableStateOf("Login Screen") }
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = text,
            modifier = Modifier
        )
    }
}