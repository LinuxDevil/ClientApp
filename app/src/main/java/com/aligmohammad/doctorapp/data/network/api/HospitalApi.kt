package com.aligmohammad.doctorapp.data.network.api

import com.aligmohammad.doctorapp.data.network.response.HospitalResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HospitalApi: BaseApi {

    @GET("/api/hospitals/private")
    suspend fun getPrivateHospitals(): HospitalResponse

    @GET("/api/hospitals/private/filter")
    suspend fun getFilteredPrivateHospitals(@Query("city") city: String): HospitalResponse

}