package com.aligmohammad.doctorapp.data.network.repository

import com.aligmohammad.doctorapp.data.network.api.PlaceApi

class PlaceRepository(private val api: PlaceApi) : BaseRepository(api) {

    suspend fun getAllPlaces(type: String) = safeApiCall {
        api.getGeneralPlaces(type)
    }

    suspend fun getFilteredPlaces(city: String, type: String) = safeApiCall {
        api.getFilteredGeneralPlaces(city, type)
    }

}