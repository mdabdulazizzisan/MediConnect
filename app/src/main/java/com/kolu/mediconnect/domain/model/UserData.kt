package com.kolu.mediconnect.domain.model

data class UserData(
    val userId: String,
    val name: String,
    var email: String,
    val phoneNumber: String,
    val age: Int,
    val emergencyContact: String,
    val createdAt: Long = System.currentTimeMillis()
)