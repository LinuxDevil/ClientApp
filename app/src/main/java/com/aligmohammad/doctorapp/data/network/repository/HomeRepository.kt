package com.aligmohammad.doctorapp.data.network.repository

import com.aligmohammad.doctorapp.data.model.UserInfoModel
import com.aligmohammad.doctorapp.data.network.api.InsuranceCompanyApi
import com.aligmohammad.doctorapp.data.network.api.MenuApi
import com.aligmohammad.doctorapp.data.network.api.UserApi
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val api: MenuApi,
    private val insuranceCompanyApi: InsuranceCompanyApi,
    private val userApi: UserApi
) : BaseRepository(api) {

    suspend fun getMenuItem() = safeApiCall {
        api.getMenuItems()
    }

    suspend fun getSubMenuItem() = safeApiCall {
        api.getSubMenuItems()
    }

    suspend fun getInsuranceCompanyApi() = safeApiCall {
        insuranceCompanyApi.getInsurances()
    }

    suspend fun addUserInfo(userDetails: UserInfoModel) = safeApiCall {
        userApi.addUserDetails(userDetails)
    }

}