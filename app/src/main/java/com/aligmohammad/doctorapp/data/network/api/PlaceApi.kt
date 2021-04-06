package com.aligmohammad.doctorapp.data.network.api

import com.aligmohammad.doctorapp.data.network.responses.DoctorResponse
import com.aligmohammad.doctorapp.data.network.responses.PlaceResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceApi : BaseApi {

    @GET("/api/doctors/all")
    suspend fun getAllDoctors(): DoctorResponse

    @GET("/api/places/private/filter")
    suspend fun getFilteredGeneralPlaces(
        @Query("city") city: String,
        @Query("type") type: String
    ): PlaceResponse

    @GET("/api/places/private")
    suspend fun getGeneralPlaces(@Query("type") type: String): PlaceResponse

}