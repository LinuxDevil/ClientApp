package com.aligmohammad.doctorapp.data.model.dto

data class AppointmentDTO(
    val date: String?,
    val time: String?,
    val location: String?,
    val shift: String?,
    val user: String?,
    val doctor: String?,
    val place: String?,
    val hospitalId: String?,
    val type: String?,
    val tests: String? = null
)
