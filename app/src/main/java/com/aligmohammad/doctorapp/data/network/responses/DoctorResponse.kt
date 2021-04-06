package com.aligmohammad.doctorapp.data.network.responses

data class DoctorResponse(
    val doctors: List<DoctorInner>
)

data class DoctorInner(
    val appointmentDates: List<String>,
    val appointmentDurations: List<String>,
    val appointmentTimes: List<String>,
    val appointments: List<Int>,
    val bio: String,
    val created: String,
    val duration: String,
    val email: String,
    val hospital: Int,
    val id: Int,
    val image: String,
    val insuranceCompany: Any,
    val insuranceNumber: String,
    val isVerified: Boolean,
    val name: String,
    val nationalityId: String,
    val patients: List<User>,
    val phone: String,
    val place: Any,
    val qalifications: List<String>,
    val shiftDuration: Int,
    val updated: String,
    val username: String
)