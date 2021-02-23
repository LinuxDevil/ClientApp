package com.aligmohammad.doctorapp.data.network.api

import com.aligmohammad.doctorapp.data.model.UserDTO
import com.aligmohammad.doctorapp.data.model.UserInfoModel
import com.aligmohammad.doctorapp.data.model.UserInfoModelInsurance
import com.aligmohammad.doctorapp.data.model.UserInfoModelNationalId
import com.aligmohammad.doctorapp.data.network.response.User
import com.aligmohammad.doctorapp.data.network.responses.UserInfoResponse
import retrofit2.http.*

interface UserApi: BaseApi {

    @Headers("Content-Type: application/json")
    @POST("/user-infos")
    suspend fun addUserDetails(@Body userDetails: UserInfoModel): UserInfoResponse

    @Headers("Content-Type: application/json")
    @PUT("/api/user")
    suspend fun updateUserDetails(@Body userDetails: UserDTO): User

}