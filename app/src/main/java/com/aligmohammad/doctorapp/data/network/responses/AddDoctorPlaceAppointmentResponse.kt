package com.aligmohammad.doctorapp.data.network.responses

data class AddDoctorPlaceAppointmentResponse(
    val appointmentEntity: AppointmentEntityDoctorPlace,
    val status: Status
)

data class AppointmentEntityDoctorPlace(
    val created: String,
    val date: String,
    val doctorPlaces: DoctorPlaces,
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

data class DoctorPlaces(
    val appointmentDates: List<String>,
    val appointmentDurations: List<String>,
    val appointmentTimes: List<String>,
    val created: String,
    val duration: String,
    val email: String,
    val endTime: String,
    val holidays: List<String>,
    val id: Int,
    val imageUrl: String,
    val insurances: List<String>,
    val isAvialable: Boolean,
    val nameAr: String,
    val nameEn: String,
    val phone: String,
    val shiftDuration: Int,
    val startTime: String,
    val type: String,
    val updated: String
)
