package com.kolu.mediconnect.domain.repository

import com.google.firebase.auth.FirebaseUser

sealed class AuthResult{
    data object Success : AuthResult()
    data class Error(val message: String) : AuthResult()
}
interface AuthRepository {
    suspend fun login(email: String, password: String): AuthResult
    suspend fun register(email: String, password: String): AuthResult
    fun isUserLoggedIn(): Boolean
    fun getCurrentUser(): FirebaseUser?
    fun logout()
}