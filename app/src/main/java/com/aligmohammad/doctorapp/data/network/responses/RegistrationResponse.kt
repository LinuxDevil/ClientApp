package com.aligmohammad.doctorapp.data.network.responses

import com.aligmohammad.doctorapp.data.model.Status
import com.aligmohammad.doctorapp.data.model.User

data class AuthResponse(
    val status: Status,
    val user: User
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