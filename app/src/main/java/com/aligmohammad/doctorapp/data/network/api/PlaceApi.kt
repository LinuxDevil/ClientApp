package com.aligmohammad.doctorapp.data.network.api

import com.aligmohammad.doctorapp.data.model.nest.AddAppointment
import com.aligmohammad.doctorapp.data.network.response.AppointmentResponse
import com.aligmohammad.doctorapp.data.network.response.GeneralHospitalAppointmentResponse
import com.aligmohammad.doctorapp.data.network.response.PlaceResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PlaceApi : BaseApi {

    @GET("/api/places/private/filter")
    suspend fun getFilteredGeneralPlaces(
        @Query("city") city: String,
        @Query("type") type: String
    ): PlaceResponse

    @GET("/api/places/private")
    suspend fun getGeneralPlaces(@Query("type") type: String): PlaceResponse

    @POST("/api/appointment")
    suspend fun addHospitalDoctorAppointment(@Body() appointment: AddAppointment): AppointmentResponse

    @POST("/api/appointment/place")
    suspend fun addGeneralHospitalAppointment(@Body() appointment: AddAppointment): GeneralHospitalAppointmentResponse


}