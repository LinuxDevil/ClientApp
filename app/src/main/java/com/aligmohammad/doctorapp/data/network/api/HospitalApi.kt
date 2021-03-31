package com.aligmohammad.doctorapp.data.network.api

import com.aligmohammad.doctorapp.data.model.nest.AddAppointment
import com.aligmohammad.doctorapp.data.network.response.AppointmentResponse
import com.aligmohammad.doctorapp.data.network.response.GeneralHospitalAppointmentResponse
import com.aligmohammad.doctorapp.data.network.response.HospitalResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface HospitalApi : BaseApi {

    @GET("/api/hospitals/private")
    suspend fun getPrivateHospitals(@Query("langId") langId: String): HospitalResponse

    @GET("/api/hospitals/private/filter")
    suspend fun getFilteredPrivateHospitals(
        @Query("city") city: String,
        @Query("langId") langId: String
    ): HospitalResponse

    @GET("/api/hospitals/general/filter")
    suspend fun getFilteredGenernalHospitals(
        @Query("city") city: String,
        @Query("langId") langId: String
    ): HospitalResponse

    @GET("/api/hospitals/general")
    suspend fun getGeneralHospitals(@Query("langId") langId: String): HospitalResponse

    @POST("/api/appointment")
    suspend fun addHospitalDoctorAppointment(@Body() appointment: AddAppointment): AppointmentResponse

    @POST("/api/appointment/hospital")
    suspend fun addGeneralHospitalAppointment(@Body() appointment: AddAppointment): GeneralHospitalAppointmentResponse

}