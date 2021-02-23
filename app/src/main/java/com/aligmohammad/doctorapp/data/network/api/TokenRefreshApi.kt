package com.aligmohammad.doctorapp.data.network.api

import com.aligmohammad.doctorapp.data.network.responses.TokenResponse
import retrofit2.http.*

data class AuthToken(val username: String?)

interface TokenRefreshApi : BaseApi {

    @Headers("Content-Type: application/json")
    @POST("/api/users/refreshtoken")
    suspend fun refreshAccessToken(
        @Body username: AuthToken
    ): TokenResponse
}