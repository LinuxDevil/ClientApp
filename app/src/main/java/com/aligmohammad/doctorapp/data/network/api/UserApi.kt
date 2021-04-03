package com.aligmohammad.doctorapp.data.network.api

import com.aligmohammad.doctorapp.data.model.dto.UserDTO
import com.aligmohammad.doctorapp.data.model.dto.UserInfoModel
import com.aligmohammad.doctorapp.data.network.response.User
import com.aligmohammad.doctorapp.data.network.responses.UserAppointments
import com.aligmohammad.doctorapp.data.network.responses.UserInfoResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT

interface UserApi: BaseApi {

    @Headers("Content-Type: application/json")
    @POST("/user-infos")
    suspend fun addUserDetails(@Body userDetails: UserInfoModel): UserInfoResponse

    @Headers("Content-Type: application/json")
    @PUT("/api/user")
    suspend fun updateUserDetails(@Body userDetails: UserDTO): User

    @Headers("Content-Type: application/json")
    @POST("/api/appointment/getUserAppointments")
    suspend fun getUserAppointments(@Body() username: String): UserAppointments

}