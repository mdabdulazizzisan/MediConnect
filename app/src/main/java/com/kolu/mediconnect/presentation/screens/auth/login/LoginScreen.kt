package com.kolu.mediconnect.presentation.screens.auth.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            modifier = Modifier.width(300.dp),
            label = { Text(text = "Email") },
            value = email,
            onValueChange = { email = it },
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
            onPasswordChange = { password = it },
            passwordVisibility = passwordVisibility,
            onVisibilityChange = { passwordVisibility = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row {
            Text(
                text = "Don't have account? ",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                modifier = Modifier
                    .clickable {
                        /*TODO*/
                    },
                text = "Sign Up",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}


@Composable
fun OutlinedTextFieldPassword(
    password: String = "",
    onPasswordChange: (String) -> Unit,
    passwordVisibility: Boolean,
    onVisibilityChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val visibilityIcon = if (passwordVisibility)
        Icons.Default.Visibility else Icons.Default.VisibilityOff
    OutlinedTextField(
        modifier = modifier,
        label = { Text(text = "Password") },
        value = password,
        onValueChange = onPasswordChange,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "Password Icon"
            )
        },
        trailingIcon = {
            IconButton(onClick = { onVisibilityChange(!passwordVisibility) }) {
                Icon(
                    imageVector = visibilityIcon,
                    contentDescription = if (passwordVisibility) "Hide Password" else "Show Password"
                )
            }
        },
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        singleLine = true
    )
}
