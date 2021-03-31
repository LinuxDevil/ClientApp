package com.aligmohammad.doctorapp.data.network.responses

data class DoctorResponse(
    val doctors: List<DoctorResponseItem>
)

data class DoctorResponseItem(
    val appointmentDates: Any,
    val appointmentDurations: Any,
    val appointmentTimes: Any,
    val appointments: List<Any>,
    val bio: String,
    val created: String,
    val duration: String,
    val email: String,
    val hospital: Any,
    val id: Int,
    val image: String?,
    val insuranceCompany: Any,
    val insuranceNumber: String,
    val isVerified: Boolean,
    val name: String,
    val nationalityId: String,
    val patients: List<Any>,
    val phone: String,
    val qalifications: List<Any>,
    val shiftDuration: Int,
    val updated: String,
    val username: String
)