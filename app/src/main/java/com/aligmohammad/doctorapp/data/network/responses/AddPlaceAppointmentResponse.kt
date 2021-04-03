package com.aligmohammad.doctorapp.data.network.responses

data class AddPlaceAppointmentResponse(
    val appointmentEntity: AppointmentEntityPlace,
    val status: Status
)

data class AppointmentEntityPlace(
    val created: String,
    val date: String,
    val id: Int,
    val imageUrl: Any,
    val inProgress: Boolean,
    val location: String,
    val place: Place,
    val rate: Int,
    val shift: String,
    val tests: String,
    val time: String,
    val updated: String,
    val user: User
)
