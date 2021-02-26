package com.aligmohammad.doctorapp.data.network.repository

import com.aligmohammad.doctorapp.data.network.api.HospitalApi
import javax.inject.Inject

class HospitalRepository @Inject constructor(
    private val api: HospitalApi
) : BaseRepository(api) {

    suspend fun getPrivateHospitals() = safeApiCall {
        api.getPrivateHospitals()
    }

    suspend fun getFilteredPrivateHospitals(city: String) = safeApiCall {
        api.getFilteredPrivateHospitals(city)
    }

}