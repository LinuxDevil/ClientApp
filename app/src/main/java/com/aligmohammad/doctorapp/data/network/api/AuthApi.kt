package com.aligmohammad.doctorapp.data.network.api

import com.aligmohammad.doctorapp.data.model.RegisterLoginData
import com.aligmohammad.doctorapp.data.network.responses.LoginResponse
import com.aligmohammad.doctorapp.data.model.UserLoginData
import com.aligmohammad.doctorapp.data.model.nest.VerifyOTP
import com.aligmohammad.doctorapp.data.network.response.AuthResponse
import com.aligmohammad.doctorapp.data.network.response.User
import com.aligmohammad.doctorapp.data.network.response.VerifyResponse
import okhttp3.Response

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthApi: BaseApi {

    @Headers("Content-Type: application/json")
    @POST("/api/users/login")
    suspend fun login(@Body userLoginData: UserLoginData): AuthResponse

    @Headers("Content-Type: application/json")
    @POST("/api/users")
    suspend fun register(@Body userLoginData: RegisterLoginData): AuthResponse

    @Headers("Content-Type: application/json")
    @POST("/api/users/verify")
    suspend fun verifyCode(@Body code: VerifyOTP): VerifyResponse

    @Headers("Content-Type: application/json")
    @GET("/api/user/current")
    suspend fun getCurrentUser(): User

}