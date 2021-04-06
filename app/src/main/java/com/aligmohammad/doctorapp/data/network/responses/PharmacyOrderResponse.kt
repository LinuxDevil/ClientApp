package com.aligmohammad.doctorapp.data.network.responses

data class PharmacyOrderResponse(
    val length: Int,
    val orders: List<Order>,
    val status: Status
)

data class Order(
    val created: String,
    val id: Int,
    val medicine: String,
    val place: Place,
    val updated: String,
    val user: User
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