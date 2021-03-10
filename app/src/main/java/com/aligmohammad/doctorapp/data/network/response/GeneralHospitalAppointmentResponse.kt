package com.aligmohammad.doctorapp.data.network.response

data class GeneralHospitalAppointmentResponse(
    val created: String,
    val date: String,
    val hospital: HospitalResponseItem,
    val id: Int,
    val imageUrl: Any,
    val inProgress: Boolean,
    val location: String,
    val rate: Int,
    val shift: String,
    val tests: String,
    val time: String,
    val updated: String,
    val user: User
)


