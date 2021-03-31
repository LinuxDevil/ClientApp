package com.aligmohammad.doctorapp.data.network.response

data class UserAppointments(
    val length: Int,
    val status: Status,
    val userAppointments: List<UserAppointment>
)

data class Status(
    val message: String,
    val status: Int
)

data class UserAppointment(
    val created: String,
    val date: String,
    val id: Int,
    val imageUrl: Any,
    val inProgress: Boolean,
    val location: String,
    val rate: Int,
    val shift: String,
    val tests: String,
    val time: String,
    val updated: String
)