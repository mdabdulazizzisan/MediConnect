package com.kolu.mediconnect.presentation.screens.auth.di

import com.kolu.mediconnect.presentation.screens.auth.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val authModule = module {
    viewModelOf<AuthViewModel>(::AuthViewModel)
}