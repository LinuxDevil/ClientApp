package com.aligmohammad.doctorapp.data.network.responses

import com.aligmohammad.doctorapp.data.model.Status

data class RegistrationResponse(
    val status: Status,
    val user: UserRegister
)

data class UserRegister(
    val bio: String,
    val city: String,
    val created: String,
    val district: String,
    val email: String,
    val id: Int,
    val image: Any,
    val insuranceNumber: String,
    val name: String,
    val nationalityId: String,
    val nickname: String,
    val token: String,
    val updated: String,
    val username: String
)