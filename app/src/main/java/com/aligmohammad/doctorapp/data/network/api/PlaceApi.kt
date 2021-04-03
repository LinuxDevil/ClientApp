package com.aligmohammad.doctorapp.data.network.api

import com.aligmohammad.doctorapp.data.model.nest.AddAppointment
import com.aligmohammad.doctorapp.data.network.responses.AppointmentResponse
import com.aligmohammad.doctorapp.data.network.responses.DoctorResponse
import com.aligmohammad.doctorapp.data.network.responses.PlaceResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
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

    @POST("/api/appointment")
    suspend fun addHospitalDoctorAppointment(@Body() appointment: AddAppointment): AppointmentResponse

    @POST("/api/appointment/place")
    suspend fun addGeneralHospitalAppointment(@Body() appointment: AddAppointment): GeneralHospitalAppointmentResponse


}