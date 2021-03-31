package com.aligmohammad.doctorapp.data.network.repository

import com.aligmohammad.doctorapp.data.network.api.BaseApi
import com.aligmohammad.doctorapp.data.network.api.SafeApiCall

abstract class BaseRepository(private val api: BaseApi): SafeApiCall {

    suspend fun logout() = safeApiCall {
        api.logout()
    }

}