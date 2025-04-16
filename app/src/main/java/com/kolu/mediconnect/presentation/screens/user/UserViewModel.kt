package com.kolu.mediconnect.presentation.screens.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kolu.mediconnect.data.repository.UserRepo
import com.kolu.mediconnect.domain.model.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserViewModel(
    private val userRepository: UserRepo,
) : ViewModel() {
    private val _user = MutableStateFlow(
        UserData(
            userId = "",
            name = "",
            email = "",
            phoneNumber = "",
            age = 0,
            emergencyContact = ""
        )
    )
    val user = _user.asStateFlow()
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading
    
    private val _profileUpdateStatus = MutableStateFlow<ProfileUpdateStatus?>(null)
    val profileUpdateStatus: StateFlow<ProfileUpdateStatus?> = _profileUpdateStatus

    init {
        loadUserData()
    }

    fun loadUserData(onFailure: (String) -> Unit = {}) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val userData = userRepository.getUserData()
                _user.value = userData
            } catch (e: Exception) {
                onFailure(e.message ?: "Unknown error")
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    fun updateUserData(userData: UserData) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val success = userRepository.updateUserData(userData)
                if (success) {
                    _user.value = userData
                    _profileUpdateStatus.value = ProfileUpdateStatus.Success
                } else {
                    _profileUpdateStatus.value = ProfileUpdateStatus.Error("Failed to update profile")
                }
            } catch (e: Exception) {
                _profileUpdateStatus.value = ProfileUpdateStatus.Error(e.message ?: "Unknown error")
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    fun resetUpdateStatus() {
        _profileUpdateStatus.value = null
    }
    
    sealed class ProfileUpdateStatus {
        object Success : ProfileUpdateStatus()
        data class Error(val message: String) : ProfileUpdateStatus()
    }
}
