package com.kolu.mediconnect.domain.model

data class UserData(
    val userId: String,
    val name: String,
    var email: String,
    val phoneNumber: String,
    val age: Int,
    val emergencyContact: String,
    val createdAt: Long = System.currentTimeMillis()
){
    constructor() : this(
        userId = "",
        name = "",
        email = "",
        phoneNumber = "",
        age = 0,
        emergencyContact = ""
    )
}