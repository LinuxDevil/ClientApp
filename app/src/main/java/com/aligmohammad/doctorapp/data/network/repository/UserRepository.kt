package com.aligmohammad.doctorapp.data.network.repository

import com.aligmohammad.doctorapp.data.model.UserDTO
import com.aligmohammad.doctorapp.data.model.UserInfoModel
import com.aligmohammad.doctorapp.data.network.api.UserApi
import com.aligmohammad.doctorapp.data.network.responses.UserInfoResponse
import javax.inject.Inject

class UserRepository @Inject constructor(private val api: UserApi): BaseRepository(api) {

    suspend fun addUserInfo(userInfo: UserInfoModel) = safeApiCall {
        api.addUserDetails(userInfo)
    }

    suspend fun updateUser(userDto: UserDTO) = safeApiCall {
        api.updateUserDetails(userDto)
    }

}