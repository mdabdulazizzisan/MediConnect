package com.kolu.mediconnect.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kolu.mediconnect.ui.theme.MediConnectTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    onBookAnAppointmentClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        floatingActionButton = { Fab(onBookAnAppointmentClick = onBookAnAppointmentClick) }
    ) {
        Text(text = "Home Screen")
    }
}

@Composable
fun Fab(
    modifier: Modifier = Modifier,
    onBookAnAppointmentClick: () -> Unit = {}
) {
    FloatingActionButton(onClick = {
        onBookAnAppointmentClick()
    }) {
        Row(modifier = Modifier.padding(10.dp)) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add"
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "Book an appointment",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomeContentPrev() {
    MediConnectTheme {
        Scaffold { innerPadding ->
            HomeContent(modifier = Modifier.padding(innerPadding))

        }
    }
}