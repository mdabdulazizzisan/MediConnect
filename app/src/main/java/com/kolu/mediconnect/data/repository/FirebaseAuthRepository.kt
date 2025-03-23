package com.kolu.mediconnect.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.kolu.mediconnect.domain.model.UserData
import com.kolu.mediconnect.domain.repository.AuthRepository
import com.kolu.mediconnect.domain.repository.AuthResult
import kotlinx.coroutines.tasks.await

class FirebaseAuthRepository(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) : AuthRepository {

    override suspend fun login(email: String, password: String): AuthResult {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            if (result.user != null) {
                AuthResult.Success
            } else {
                AuthResult.Error("Login failed")
            }
        } catch (e: Exception) {
            AuthResult.Error(e.message ?: "An error occurred")
        }
    }

    override suspend fun register(
        userData: UserData,
        password: String
    ): AuthResult {
        return try {
            val result = auth.createUserWithEmailAndPassword(userData.email, password).await()
            result.user?.let { firebaseUser ->
                firestore.collection("users")
                    .document(firebaseUser.uid)
                    .set(
                        userData.copy(userId = firebaseUser.uid)
                    ).await()
                AuthResult.Success
            } ?: AuthResult.Error("Registration failed")

        } catch (e: Exception) {
            AuthResult.Error(e.message ?: "An error occurred")
        }
    }

    override fun isUserLoggedIn(): Boolean {
        return auth.currentUser != null
    }

    override fun getCurrentUser(): FirebaseUser? {
        return auth.currentUser
    }

    override fun logout() {
        auth.signOut()
    }

}