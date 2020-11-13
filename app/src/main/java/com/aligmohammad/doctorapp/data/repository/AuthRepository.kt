package com.aligmohammad.doctorapp.data.repository

import com.aligmohammad.doctorapp.data.api.ApiService
import com.aligmohammad.doctorapp.data.api.AuthApi
import com.aligmohammad.doctorapp.data.database.AppDatabase

class AuthRepository(private val api: AuthApi, private val database: AppDatabase) : ApiService() {

    suspend fun registerUser(username: String, phoneNumber: String) {

    }

}