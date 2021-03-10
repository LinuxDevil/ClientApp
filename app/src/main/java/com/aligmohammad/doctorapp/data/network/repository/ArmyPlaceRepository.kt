package com.aligmohammad.doctorapp.data.network.repository

import com.aligmohammad.doctorapp.data.network.api.ArmyPlacesApi

class ArmyPlaceRepository(private val api: ArmyPlacesApi) : BaseRepository(api) {

    suspend fun getArmyPlaces() = safeApiCall {
        api.getGeneralArmyArmyPlaces()
    }

    suspend fun getFilteredArmyPlaces(city: String) = safeApiCall {
        api.getFilteredGeneralArmyPlaces(city)
    }

}