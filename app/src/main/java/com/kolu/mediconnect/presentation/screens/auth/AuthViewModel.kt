package com.kolu.mediconnect.presentation.screens.auth

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel: ViewModel() {
    private val _email: MutableStateFlow<String> = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _password: MutableStateFlow<String> = MutableStateFlow("")
    val password = _password.asStateFlow()

    fun setEmail(email: String){_email.value = email}
    fun setPassword(password: String){_password.value = password}
}