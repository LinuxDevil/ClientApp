package com.aligmohammad.doctorapp.data.network.repository

import com.aligmohammad.doctorapp.data.network.api.DoctorPlaceApi

class DoctorPlaceRepository(private val api: DoctorPlaceApi) : BaseRepository(api) {

    suspend fun getDoctorPlaces() = safeApiCall {
        api.getGeneralDoctorDoctorPlaces()
    }

    suspend fun getFilteredDoctorPlaces(city: String) = safeApiCall {
        api.getFilteredGeneralDoctorPlaces(city)
    }
}