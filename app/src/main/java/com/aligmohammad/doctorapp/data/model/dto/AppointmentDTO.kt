package com.aligmohammad.doctorapp.data.model.dto

data class AppointmentDTO(
    val date: String,
    val doctor: String,
    val hospitalId: String,
    val location: String,
    val place: String,
    val shift: String,
    val time: String,
    val user: String
)