package com.aligmohammad.doctorapp.data.network.api

import com.aligmohammad.doctorapp.data.model.nest.AddAppointment
import com.aligmohammad.doctorapp.data.network.responses.AppointmentResponse
import com.aligmohammad.doctorapp.data.network.responses.DoctorPlaceResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DoctorPlaceApi : BaseApi {

    @GET("/api/doctorplaces/general/filter")
    suspend fun getFilteredGeneralDoctorPlaces(@Query("city") city: String): DoctorPlaceResponse

    @GET("/api/doctorplaces/general")
    suspend fun getGeneralDoctorDoctorPlaces(): DoctorPlaceResponse

    @POST("/api/appointment")
    suspend fun addHospitalDoctorAppointment(@Body() appointment: AddAppointment): AppointmentResponse

    @POST("/api/appointment/place")
    suspend fun addGeneralHospitalAppointment(@Body() appointment: AddAppointment): GeneralHospitalAppointmentResponse

}