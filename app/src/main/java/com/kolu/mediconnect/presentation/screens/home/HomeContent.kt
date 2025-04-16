package com.kolu.mediconnect.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kolu.mediconnect.R
import com.kolu.mediconnect.presentation.components.BannerCarousel
import com.kolu.mediconnect.ui.theme.MediConnectTheme
import kotlinx.coroutines.delay

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    onBookAnAppointmentClick: () -> Unit = {},
    onProfileClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        floatingActionButton = { Fab(onBookAnAppointmentClick = onBookAnAppointmentClick) },
        topBar = {
            HomeTopBar(onProfileClick = {onProfileClick()})
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            BannerCarousel(onBannerClick = onBookAnAppointmentClick)
        }
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier,
    onProfileClick: () -> Unit = {}) {
    TopAppBar(
        title = {
            Column {
                Text(text = "MediConnect")
                Text(
                    text = "username",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        },
        actions = {
            IconButton(
                onClick = { onProfileClick() },
            ) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Profile",
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f))
                        .padding(4.dp)
                )
            }
        }

    )

}



@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomeContentPrev() {
    MediConnectTheme {
        HomeContent()
    }
}
