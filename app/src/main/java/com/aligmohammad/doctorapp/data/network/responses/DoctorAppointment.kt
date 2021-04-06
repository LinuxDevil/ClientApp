package com.aligmohammad.doctorapp.data.network.responses

data class DoctorAppointment(
    val appointmentEntity: AppointmentEntity,
    val status: Status
)