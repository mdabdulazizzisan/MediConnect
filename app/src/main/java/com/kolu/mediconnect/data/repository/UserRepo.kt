package com.kolu.mediconnect.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.kolu.mediconnect.domain.model.UserData
import com.kolu.mediconnect.domain.repository.UserRepository
import kotlinx.coroutines.tasks.await

class UserRepo(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) : UserRepository {
    override suspend fun getUserData(): UserData {
        val userId = auth.currentUser?.uid
            ?: throw Exception("User not logged in")

        return firestore.collection("users")
            .document(userId)
            .get()
            .await()
            .toObject(UserData::class.java)
            ?: throw Exception("User data not found")
    }
}