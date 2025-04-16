package com.kolu.mediconnect.presentation.screens.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kolu.mediconnect.domain.model.Doctor
import com.kolu.mediconnect.presentation.components.BannerCarousel
import com.kolu.mediconnect.ui.theme.MediConnectTheme
import kotlinx.coroutines.delay

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    onBookAnAppointmentClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onNavigateToEmergencyScreen: () -> Unit,
    onAllAppointmentScreen: () -> Unit = {},
    username: String = "John Doe"

) {
    val scrollState = rememberScrollState()
    
    Scaffold(
        modifier = modifier.fillMaxSize(),
        floatingActionButton = { Fab(onBookAnAppointmentClick = onBookAnAppointmentClick) },
        topBar = {
            HomeTopBar(
                username = username,
                onProfileClick = { onProfileClick() },
                hasNotifications = true
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(scrollState)
        ) {
            BannerCarousel(onBannerClick = onBookAnAppointmentClick)
            
            AnimatedVisibility(
                visible = true,
                enter = fadeIn(animationSpec = tween(durationMillis = 500)) +
                        slideInVertically(
                            initialOffsetY = { 100 },
                            animationSpec = tween(durationMillis = 500)
                        )
            ) {
                QuickActionsSection(
                    onActionClick = { actionType ->
                        // Handle different actions
                        when (actionType) {
                            "appointment" -> onAllAppointmentScreen()
                            "emergency" -> onNavigateToEmergencyScreen()
                            else -> {}
                        }
                    }
                )
            }
            
            AnimatedVisibility(
                visible = true,
                enter = fadeIn(animationSpec = tween(durationMillis = 700, delayMillis = 300)) +
                        slideInVertically(
                            initialOffsetY = { 100 },
                            animationSpec = tween(durationMillis = 700, delayMillis = 300)
                        )
            ) {
                UpcomingAppointmentSection()
            }
            
            AnimatedVisibility(
                visible = true,
                enter = fadeIn(animationSpec = tween(durationMillis = 900, delayMillis = 600)) +
                        slideInVertically(
                            initialOffsetY = { 100 },
                            animationSpec = tween(durationMillis = 900, delayMillis = 600)
                        )
            ) {
                PopularDoctorsSection(
                    onDoctorClick = { doctorId ->
                        // Handle doctor click
                    }
                )
            }
            
            AnimatedVisibility(
                visible = true,
                enter = fadeIn(animationSpec = tween(durationMillis = 1100, delayMillis = 900)) +
                        slideInVertically(
                            initialOffsetY = { 100 },
                            animationSpec = tween(durationMillis = 1100, delayMillis = 900)
                        )
            ) {
                HealthTipsSection()
            }
            
            Spacer(modifier = Modifier.height(80.dp)) // Space for FAB
        }
    }
}

@Composable
fun QuickActionsSection(
    modifier: Modifier = Modifier,
    onActionClick: (String) -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Quick Actions",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            QuickActionItem(
                icon = Icons.Default.DateRange,
                title = "Appointments",
                backgroundColor = MaterialTheme.colorScheme.primaryContainer,
                onClick = { onActionClick("appointment") }
            )
            
            QuickActionItem(
                icon = Icons.Default.MedicalServices,
                title = "Medications",
                backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                onClick = { onActionClick("medication") }
            )
            
            QuickActionItem(
                icon = Icons.Default.LocalHospital,
                title = "Emergency",
                backgroundColor = MaterialTheme.colorScheme.errorContainer,
                isPulsing = true,
                onClick = {
                    onActionClick("emergency") }
            )
            
            QuickActionItem(
                icon = Icons.Default.Favorite,
                title = "Health",
                backgroundColor = MaterialTheme.colorScheme.tertiaryContainer,
                onClick = { onActionClick("health") }
            )
        }
    }
}

@Composable
fun QuickActionItem(
    icon: ImageVector,
    title: String,
    backgroundColor: Color,
    isPulsing: Boolean = false,
    onClick: () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = if (isPulsing) 1.1f else 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale"
    )
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .scale(if (isPulsing) scale else 1f)
            .clickable { onClick() }
            .padding(8.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(backgroundColor)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier.size(28.dp),
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun UpcomingAppointmentSection(
    modifier: Modifier = Modifier
) {
    var isAppointment by remember { mutableStateOf(true) }
    
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isAppointment) 
                MaterialTheme.colorScheme.primaryContainer 
            else 
                MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Upcoming Appointment",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                
                PulsingDot(isActive = isAppointment)
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            if (isAppointment) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.surface)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Doctor",
                            modifier = Modifier
                                .size(30.dp)
                                .align(Alignment.Center),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    
                    Spacer(modifier = Modifier.width(12.dp))
                    
                    Column {
                        Text(
                            text = "Dr. Sarah Johnson",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Cardiologist",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Today, 10:30 AM",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(12.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Card(
                        modifier = Modifier
                            .height(36.dp)
                            .clickable { /* Handle reschedule */ },
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        )
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Reschedule",
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                    
                    Spacer(modifier = Modifier.width(8.dp))
                    
                    Card(
                        modifier = Modifier
                            .height(36.dp)
                            .clickable { /* Handle confirm */ },
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Confirm",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onPrimary,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No upcoming appointments",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Composable
fun PulsingDot(
    isActive: Boolean,
    modifier: Modifier = Modifier
) {
    if (!isActive) return
    
    val infiniteTransition = rememberInfiniteTransition(label = "pulsingDot")
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.2f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "alpha"
    )
    
    Box(
        modifier = modifier
            .size(12.dp)
            .alpha(alpha)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
    )
}

@Composable
fun PopularDoctorsSection(
    modifier: Modifier = Modifier,
    onDoctorClick: (Int) -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Popular Doctors",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            
            Text(
                text = "See All",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable { /* Navigate to all doctors */ }
            )
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        LazyRow(
            contentPadding = PaddingValues(horizontal = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(getDummyDoctors()) { doctor ->
                DoctorCard(
                    doctor = doctor,
                    onClick = { onDoctorClick(doctor.id) }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorCard(
    doctor: Doctor,
    onClick: () -> Unit
) {
    var scale by remember { mutableStateOf(1f) }
    val animatedScale by animateFloatAsState(
        targetValue = scale,
        animationSpec = tween(durationMillis = 200),
        label = "scale"
    )
    
    Card(
        modifier = Modifier
            .width(160.dp)
            .scale(animatedScale)
            .clickable { 
                onClick()
            },
        shape = RoundedCornerShape(12.dp),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Doctor",
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.Center),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = doctor.name,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            
            Text(
                text = doctor.specialty,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            
            Spacer(modifier = Modifier.height(4.dp))
            
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = "Rating",
                    modifier = Modifier.size(16.dp),
                    tint = Color(0xFFFFC107)
                )
                
                Spacer(modifier = Modifier.width(4.dp))
                
                Text(
                    text = doctor.rating.toString(),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
    
    LaunchedEffect(doctor.id) {
        delay(doctor.id * 100L)
        scale = 1.05f
        delay(200)
        scale = 1f
    }
}

@Composable
fun HealthTipsSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Health Tips",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        getDummyHealthTips().forEach { tip ->
            ExpandableHealthTip(healthTip = tip)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ExpandableHealthTip(
    healthTip: HealthTip,
    modifier: Modifier = Modifier
) {
    var isExpanded by remember { mutableStateOf(false) }
    
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { isExpanded = !isExpanded },
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = healthTip.title,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                
                Icon(
                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = if (isExpanded) "Collapse" else "Expand"
                )
            }
            
            AnimatedVisibility(
                visible = isExpanded,
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut()
            ) {
                Column(modifier = Modifier.padding(top = 8.dp)) {
                    Divider()
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = healthTip.content,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@Composable
fun Fab(
    modifier: Modifier = Modifier,
    onBookAnAppointmentClick: () -> Unit = {}
) {
    val infiniteTransition = rememberInfiniteTransition(label = "fab")
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale"
    )
    
    FloatingActionButton(
        onClick = { onBookAnAppointmentClick() },
        modifier = Modifier.scale(scale)
    ) {
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
    username: String = "User",
    hasNotifications: Boolean = false,
    onProfileClick: () -> Unit = {}
) {
    TopAppBar(
        title = {
            Column {
                Text(text = "MediConnect")
                Text(
                    text = "Welcome, $username",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        },
        actions = {
            BadgedBox(
                badge = {
                    if (hasNotifications) {
                        Badge { Text("1") }
                    }
                }
            ) {
                IconButton(onClick = { /* Handle notifications */ }) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notifications"
                    )
                }
            }
            
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



data class HealthTip(
    val id: Int,
    val title: String,
    val content: String
)

// Dummy data functions
fun getDummyDoctors(): List<Doctor> {
    return listOf(
        Doctor(1, "Dr. Sarah Johnson", "Cardiologist", 4.8),
        Doctor(2, "Dr. Michael Chen", "Dermatologist", 4.7),
        Doctor(3, "Dr. Emily Williams", "Neurologist", 4.9),
        Doctor(4, "Dr. David Rodriguez", "Pediatrician", 4.6),
        Doctor(5, "Dr. Lisa Wong", "Orthopedist", 4.5)
    )
}

fun getDummyHealthTips(): List<HealthTip> {
    return listOf(
        HealthTip(
            1,
            "Stay Hydrated",
            "Drink at least 8 glasses of water daily to maintain proper hydration. This helps your body function optimally and supports overall health."
        ),
        HealthTip(
            2,
            "Regular Exercise",
            "Aim for at least 30 minutes of moderate exercise 5 times a week. Regular physical activity improves cardiovascular health, boosts mood, and helps maintain a healthy weight."
        ),
        HealthTip(
            3,
            "Balanced Diet",
            "Incorporate a variety of fruits, vegetables, whole grains, and lean proteins into your diet. A balanced diet provides essential nutrients for optimal health and disease prevention."
        )
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomeContentPrev() {
    MediConnectTheme {
    }
}
