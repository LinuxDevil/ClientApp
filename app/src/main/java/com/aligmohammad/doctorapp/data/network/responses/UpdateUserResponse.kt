package com.aligmohammad.doctorapp.data.network.responses

import com.aligmohammad.doctorapp.data.model.Status

data class UpdateUserResponse(
    val status: Status,
    val user: UserUpdate
)

data class UserUpdate(
    val appointments: Any,
    val bio: String,
    val city: String,
    val created: String,
    val district: String,
    val email: String,
    val followee: List<Any>,
    val followers: List<Any>,
    val id: Int,
    val image: String,
    val insuranceCompany: InsuranceCompany,
    val insuranceNumber: String,
    val name: String,
    val nationalityId: String,
    val nickname: String,
    val subUsers: List<Int>,
    val updated: String,
    val username: String
)

data class InsuranceCompany(
    val created: String,
    val id: Int,
    val nameAr: String,
    val nameEn: String,
    val type: String,
    val updated: String
)