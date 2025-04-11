package com.kolu.mediconnect.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.kolu.mediconnect.presentation.screens.user.UserViewModel
import org.koin.core.module.dsl.singleOf
import com.kolu.mediconnect.data.repository.UserRepo

val userModule = module {
    viewModelOf(::UserViewModel)
    singleOf(::UserRepo)
}