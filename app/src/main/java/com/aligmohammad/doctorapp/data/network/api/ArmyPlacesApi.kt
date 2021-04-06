package com.aligmohammad.doctorapp.data.network.api

import com.aligmohammad.doctorapp.data.model.dto.AppointmentDTO
import com.aligmohammad.doctorapp.data.network.responses.AddPlaceAppointmentResponse
import com.aligmohammad.doctorapp.data.network.responses.AppointmentResponse
import com.aligmohammad.doctorapp.data.network.responses.ArmyPlaceResponse
import com.aligmohammad.doctorapp.data.network.responses.HospitalAppointment
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
    suspend fun addHospitalDoctorAppointment(@Body() appointment: AppointmentDTO): AppointmentResponse

    @POST("/api/appointment/place")
    suspend fun addGeneralPlaceAppointment(@Body() appointment: AppointmentDTO): AddPlaceAppointmentResponse

    @POST("/api/appointment/hospital")
    suspend fun addHospitalAppointment(@Body() appointment: AppointmentDTO): HospitalAppointment

}