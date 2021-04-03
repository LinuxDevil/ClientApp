package com.aligmohammad.doctorapp.data.network.responses

data class CurrentUserResponse(
    val user: CurrentUser
)

data class CurrentUser(
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