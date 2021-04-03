package com.aligmohammad.doctorapp.data.network.repository

import com.aligmohammad.doctorapp.data.model.dto.RegisterLoginData
import com.aligmohammad.doctorapp.data.model.dto.UserLoginData
import com.aligmohammad.doctorapp.data.model.nest.VerifyOTP
import com.aligmohammad.doctorapp.data.network.api.AuthApi
import com.aligmohammad.doctorapp.helpers.PreferencesStore
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val api: AuthApi,
    private val preferences: PreferencesStore
) : BaseRepository(api) {

    suspend fun login(username: String) = safeApiCall {
        api.login(UserLoginData(username))
    }

    suspend fun registerUser(username: String) = safeApiCall {
        api.register(RegisterLoginData(username))
    }

    suspend fun getCurrentUser() = safeApiCall {
        api.getCurrentUser()
    }

    suspend fun verifyCode(phoneNumber: String, code: String) = safeApiCall {
        api.verifyCode(VerifyOTP(phoneNumber, code))
    }

    suspend fun saveFirebaseUser(user: String) {
        preferences.saveFirebaseUser(user)
    }

    suspend fun saveAuthToken(token: String, refToken: String) {
        preferences.saveAccessTokens(token, refToken)
    }

    suspend fun logoutUser() {
        preferences.clear()
    }

}