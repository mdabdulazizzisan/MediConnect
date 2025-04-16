package com.kolu.mediconnect.presentation.screens.user

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.kolu.mediconnect.domain.model.UserData
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: UserViewModel,
    onNavigateBack: () -> Unit
) {
    val userState by viewModel.user.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val updateStatus by viewModel.profileUpdateStatus.collectAsState()

    // Using remember with userState as key to only initialize once
    var name by remember(userState.userId) { mutableStateOf(userState.name) }
    var email by remember(userState.userId) { mutableStateOf(userState.email) }
    var phoneNumber by remember(userState.userId) { mutableStateOf(userState.phoneNumber) }
    var age by remember(userState.userId) { mutableStateOf(if(userState.age > 0) userState.age.toString() else "") }
    var emergencyContact by remember(userState.userId) { mutableStateOf(userState.emergencyContact) }

    // Track form validity
    val isFormValid = remember(name, email, phoneNumber, age) {
        name.isNotBlank() && email.isNotBlank() &&
                phoneNumber.isNotBlank() && age.isNotBlank() &&
                age.toIntOrNull() != null
    }

    // Handle update status
    LaunchedEffect(updateStatus) {
        if (updateStatus is UserViewModel.ProfileUpdateStatus.Success) {
            delay(1500)
            viewModel.resetUpdateStatus()
            onNavigateBack()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Edit Profile") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            if (isFormValid) updateUserProfile(viewModel, userState, name, email, phoneNumber, age, emergencyContact)
                        },
                        enabled = !isLoading && isFormValid
                    ) {
                        Icon(
                            Icons.Default.Check,
                            contentDescription = "Save"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Display update status
                    updateStatus?.let { status ->
                        when (status) {
                            is UserViewModel.ProfileUpdateStatus.Success -> {
                                Surface(
                                    color = MaterialTheme.colorScheme.primaryContainer,
                                    shape = MaterialTheme.shapes.medium
                                ) {
                                    Text(
                                        "Profile updated successfully!",
                                        modifier = Modifier.padding(16.dp),
                                        color = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                }
                            }
                            is UserViewModel.ProfileUpdateStatus.Error -> {
                                Surface(
                                    color = MaterialTheme.colorScheme.errorContainer,
                                    shape = MaterialTheme.shapes.medium
                                ) {
                                    Text(
                                        "Error: ${status.message}",
                                        modifier = Modifier.padding(16.dp),
                                        color = MaterialTheme.colorScheme.onErrorContainer
                                    )
                                }
                            }
                        }
                    }

                    // Form fields
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Name") },
                        modifier = Modifier.fillMaxWidth(),
                        isError = name.isBlank(),
                        supportingText = { if (name.isBlank()) Text("Name is required") }
                    )

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier.fillMaxWidth(),
                        isError = email.isBlank(),
                        supportingText = { if (email.isBlank()) Text("Email is required") }
                    )

                    OutlinedTextField(
                        value = phoneNumber,
                        onValueChange = { phoneNumber = it },
                        label = { Text("Phone Number") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        modifier = Modifier.fillMaxWidth(),
                        isError = phoneNumber.isBlank(),
                        supportingText = { if (phoneNumber.isBlank()) Text("Phone number is required") }
                    )

                    OutlinedTextField(
                        value = age,
                        onValueChange = { age = it },
                        label = { Text("Age") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth(),
                        isError = age.isBlank() || age.toIntOrNull() == null,
                        supportingText = {
                            if (age.isBlank()) Text("Age is required")
                            else if (age.toIntOrNull() == null) Text("Enter a valid number")
                        }
                    )

                    OutlinedTextField(
                        value = emergencyContact,
                        onValueChange = { emergencyContact = it },
                        label = { Text("Emergency Contact") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Button(
                        onClick = {
                            if (isFormValid) updateUserProfile(viewModel, userState, name, email, phoneNumber, age, emergencyContact)
                        },
                        modifier = Modifier.fillMaxWidth(),
                        enabled = !isLoading && isFormValid
                    ) {
                        Text("Update Profile")
                    }
                }
            }
        }
    }
}

// Extracted function to update user profile
private fun updateUserProfile(
    viewModel: UserViewModel,
    userState: UserData,
    name: String,
    email: String,
    phoneNumber: String,
    age: String,
    emergencyContact: String
) {
    viewModel.updateUserData(
        UserData(
            userId = userState.userId,
            name = name,
            email = email,
            phoneNumber = phoneNumber,
            age = age.toIntOrNull() ?: 0,
            emergencyContact = emergencyContact
        )
    )
}