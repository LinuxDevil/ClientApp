package com.aligmohammad.doctorapp.data.network.responses

import com.aligmohammad.doctorapp.data.model.User

data class AppointmentResponse(
    val created: String,
    val date: String,
    val doctor: Doctor,
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
