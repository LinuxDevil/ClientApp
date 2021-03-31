package com.aligmohammad.doctorapp.data.network.repository

import com.aligmohammad.doctorapp.data.network.api.PlaceApi
import javax.inject.Inject

class PlaceRepository @Inject constructor(private val api: PlaceApi) : BaseRepository(api) {

    suspend fun getAllPlaces(type: String) = safeApiCall {
        api.getGeneralPlaces(type)
    }

    suspend fun getFilteredPlaces(city: String, type: String) = safeApiCall {
        api.getFilteredGeneralPlaces(city, type)
    }

    suspend fun getDoctorList() = safeApiCall {
        api.getAllDoctors()
    }

}