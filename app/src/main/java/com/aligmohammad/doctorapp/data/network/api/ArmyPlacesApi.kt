package com.aligmohammad.doctorapp.data.network.api

import com.aligmohammad.doctorapp.data.model.nest.AddAppointment
import com.aligmohammad.doctorapp.data.network.response.AppointmentResponse
import com.aligmohammad.doctorapp.data.network.response.ArmyPlaceResponse
import com.aligmohammad.doctorapp.data.network.response.GeneralHospitalAppointmentResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ArmyPlacesApi : BaseApi {

    @GET("/api/armyplaces/general/filter")
    suspend fun getFilteredGeneralArmyPlaces(@Query("city") city: String): ArmyPlaceResponse

    @GET("/api/armyplaces/general")
    suspend fun getGeneralArmyArmyPlaces(): ArmyPlaceResponse

    @POST("/api/appointment")
    suspend fun addHospitalDoctorAppointment(@Body() appointment: AddAppointment): AppointmentResponse

    @POST("/api/appointment/place")
    suspend fun addGeneralHospitalAppointment(@Body() appointment: AddAppointment): GeneralHospitalAppointmentResponse

}