package com.kolu.mediconnect.domain.repository

import com.kolu.mediconnect.domain.model.Appointment

interface AppointmentRepository {
    suspend fun bookAppointment(appointment: Appointment): String?
    suspend fun getAllAppointment(): List<Appointment>
    suspend fun getAppointmentById(id: String): Appointment?
    suspend fun updateAppointment(appointment: Appointment): Boolean
    suspend fun deleteAppointment(appointment: Appointment): Boolean
}