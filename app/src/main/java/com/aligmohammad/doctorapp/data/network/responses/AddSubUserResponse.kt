package com.aligmohammad.doctorapp.data.network.responses

import com.aligmohammad.doctorapp.data.model.Status

data class AddSubUserResponse(
    val status: Status,
    val user: UserAddSub
)

data class UserAddSub(
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
    val subUsers: List<SubUser>,
    val updated: String,
    val username: String
)

data class SubUser(
    val appointments: Any,
    val bio: String,
    val city: String,
    val created: String,
    val district: String,
    val email: String,
    val followee: List<Any>,
    val followers: List<Any>,
    val id: Int,
    val image: Any,
    val insuranceCompany: Any,
    val insuranceNumber: String,
    val name: String,
    val nationalityId: String,
    val nickname: String,
    val subUsers: List<Any>,
    val updated: String,
    val username: String
)