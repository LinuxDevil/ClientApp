package com.aligmohammad.doctorapp.data.network.responses

import com.aligmohammad.doctorapp.data.model.Status

data class AddAppointmentResponse(
    val appointmentEntity: AppointmentEntity,
    val status: Status
)

data class AppointmentEntity(
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

data class Doctor(
    val appointmentDates: List<String>,
    val appointmentDurations: List<String>,
    val appointmentTimes: List<String>,
    val bio: String,
    val created: String,
    val duration: String,
    val email: String,
    val id: Int,
    val image: String,
    val insuranceNumber: String,
    val isVerified: Boolean,
    val name: String,
    val nationalityId: String,
    val phone: String,
    val shiftDuration: Int,
    val updated: String,
    val username: String
)

data class User(
    val bio: String,
    val city: String,
    val created: String,
    val district: String,
    val email: String,
    val id: Int,
    val image: String,
    val insuranceNumber: String,
    val name: String,
    val nationalityId: String,
    val nickname: String,
    val updated: String,
    val username: String
)
