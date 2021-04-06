package com.aligmohammad.doctorapp.data.network.api

import com.aligmohammad.doctorapp.data.network.responses.DoctorPlaceResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DoctorPlaceApi : BaseApi {

    @GET("/api/doctorplaces/general/filter")
    suspend fun getFilteredGeneralDoctorPlaces(@Query("city") city: String): DoctorPlaceResponse

    @GET("/api/doctorplaces/general")
    suspend fun getGeneralDoctorDoctorPlaces(): DoctorPlaceResponse

}