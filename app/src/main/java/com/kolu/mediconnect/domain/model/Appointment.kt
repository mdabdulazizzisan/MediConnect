package com.kolu.mediconnect.domain.model

data class Appointment(
    val userId: String = "",
    val id: String = "",
    val division: String = "",
    val district: String = "",
    val thana: String = "",
    val hospital: String = "",
    val doctorName: String = "",
    val symptoms: String = "",
    val date: String = "",
    val time: String = "",
    val status: AppointmentStatus = AppointmentStatus.PENDING_APPROVAL
)

enum class AppointmentStatus(){
    PENDING_APPROVAL,
    SCHEDULED,
    REJECTED,
    RESCHEDULED,
    VISITED
}
