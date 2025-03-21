package com.kolu.mediconnect.presentation.screens.auth.register

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kolu.mediconnect.presentation.screens.auth.AuthUiState
import com.kolu.mediconnect.presentation.screens.auth.AuthViewModel
import com.kolu.mediconnect.presentation.screens.auth.login.OutlinedTextFieldPassword
import org.koin.androidx.compose.koinViewModel

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    authViewModel: AuthViewModel,
    onRegisterSuccess: () -> Unit = {}
) {
    val context = LocalContext.current
    val email by authViewModel.email.collectAsState()
    val password by authViewModel.password.collectAsState()
    val authUiState by authViewModel.authUiState.collectAsState()
    val keyboardController = LocalSoftwareKeyboardController.current
    var passwordVisibility by remember { mutableStateOf(false) }

    LaunchedEffect(authUiState) {
        when (authUiState) {
            is AuthUiState.Success -> onRegisterSuccess()
            is AuthUiState.Error -> {
                val message = (authUiState as AuthUiState.Error).message
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

                authViewModel.resetState()
            }
            else -> { }
        }
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            modifier = Modifier.width(300.dp),
            label = { Text(text = "Email") },
            value = email,
            onValueChange = { authViewModel.setEmail(it) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email Icon"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextFieldPassword(
            modifier = Modifier.width(300.dp),
            password = password,
            onPasswordChange = { authViewModel.setPassword(it) },
            passwordVisibility = passwordVisibility,
            onVisibilityChange = { passwordVisibility = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (password.length < 6) {
                Toast.makeText(context, "password is too short", Toast.LENGTH_SHORT)
                    .show()
            } else{
                keyboardController?.hide()
                authViewModel.register()
            }
        }) {
            Text(text = "Register")
        }
    }
}