package com.kolu.mediconnect.domain.repository

import com.kolu.mediconnect.domain.model.UserData

interface UserRepository {
    suspend fun getUserData(): UserData

//    suspend fun updateUserData(userData: UserData): Boolean

}