package com.kolu.mediconnect.presentation.screens.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kolu.mediconnect.data.repository.FirebaseAuthRepository
import com.kolu.mediconnect.domain.repository.AuthResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val authRepository: FirebaseAuthRepository
) : ViewModel() {

    private val _email: MutableStateFlow<String> = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _password: MutableStateFlow<String> = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _authUiState = MutableStateFlow<AuthUiState>(AuthUiState.Idle)
    val authUiState = _authUiState.asStateFlow()

    fun setEmail(email: String) {
        _email.value = email
    }

    fun setPassword(password: String) {
        _password.value = password
    }

    fun login() {
        viewModelScope.launch {
            if (_email.value.isEmpty() || _password.value.isEmpty()) {
                _authUiState.value = AuthUiState.Error("Please fill in all the fields")
                return@launch
            }
            _authUiState.value = AuthUiState.Loading
            when(val result = authRepository.login(_email.value, _password.value)){
                is AuthResult.Success ->
                    _authUiState.value = AuthUiState.Success
                is AuthResult.Error ->
                    _authUiState.value = AuthUiState.Error(result.message)
            }
        }
    }

    fun register(){
        viewModelScope.launch {
            if (_email.value.isEmpty() || _password.value.isEmpty()) {
                _authUiState.value = AuthUiState.Error("Please fill in all the fields")
                return@launch
            }
            _authUiState.value = AuthUiState.Loading
            when(val result = authRepository.register(_email.value, _password.value)){
                is AuthResult.Success ->
                    _authUiState.value = AuthUiState.Success
                is AuthResult.Error ->
                    _authUiState.value = AuthUiState.Error(result.message)
            }
        }
    }

    fun resetState() {
        _authUiState.value = AuthUiState.Idle
    }
}

sealed class AuthUiState {
    data object Idle : AuthUiState()
    data object Loading : AuthUiState()
    data class Error(val message: String) : AuthUiState()
    data object Success : AuthUiState()
}