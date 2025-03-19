package com.kolu.mediconnect.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class StartDestinationViewModel: ViewModel() {
    private val _viewState = MutableStateFlow<StartDestinationViewState>(StartDestinationViewState.Loading)
        val viewState: StateFlow<StartDestinationViewState> = _viewState.asStateFlow()

    /*************************************
    * Simulate authentication repository
     ************************************/
    private val authRepository = object {
        suspend fun checkAuthStatus(): Boolean {
            // Simulate network delay
            kotlinx.coroutines.delay(1500)
            // Return auth status for testing
            return false // kotlin.random.Random.nextBoolean() // Return random boolean
        }
    }

    private val hasLoggedIn = MutableStateFlow<Boolean?>(null)

        init {
            viewModelScope.launch {
                hasLoggedIn.value = authRepository.checkAuthStatus() //get simulated value of auth repository
                hasLoggedIn.map { isLoggedIn ->
                    when (isLoggedIn) {
                        null -> StartDestinationViewState.Loading
                        true -> StartDestinationViewState.LoggedIN
                        false -> StartDestinationViewState.NotLoggedIn
                    }
                }.collect { state ->
                    _viewState.value = state
                }
            }
        }

    sealed class StartDestinationViewState {
        data object Loading : StartDestinationViewState()
        data object LoggedIN : StartDestinationViewState()
        data object NotLoggedIn : StartDestinationViewState()
    }
}