package com.aligmohammad.doctorapp.data.network.responses

data class UserInfoResponse(
    val status: Status,
    val user: UserInner
)

data class UserInner(
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
    val subUsers: List<Any>,
    val updated: String,
    val username: String
)