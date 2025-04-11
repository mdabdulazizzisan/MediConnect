package com.kolu.mediconnect.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.kolu.mediconnect.presentation.screens.appointment.AppointmentViewModel
import org.koin.core.module.dsl.singleOf
import com.kolu.mediconnect.data.repository.AppointmentRepo

val appointmentModule = module {
    viewModelOf(::AppointmentViewModel)
    singleOf(::AppointmentRepo)
}