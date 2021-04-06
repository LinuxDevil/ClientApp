package com.aligmohammad.doctorapp.data.network.responses

data class AddPharmacyOrderResponse(
    val order: Order,
    val place: PlaceX,
    val status: Status,
    val user: UserXX
)


data class PlaceX(
    val appointmentDates: Any,
    val appointmentDurations: Any,
    val appointmentTimes: Any,
    val created: String,
    val duration: String,
    val email: String,
    val endTime: String,
    val holidays: List<String>,
    val id: Int,
    val imageUrl: String,
    val insurances: List<String>,
    val isAvialable: Boolean,
    val nameAr: String,
    val nameEn: String,
    val orders: List<Order>,
    val phone: String,
    val shiftDuration: Int,
    val startTime: String,
    val type: String,
    val updated: String
)

data class UserXX(
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

