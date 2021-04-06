package com.aligmohammad.doctorapp.data.network.responses

data class OfferResponse(
    val offers: List<Offer>,
    val status: Status
)

data class Offer(
    val beginDate: String,
    val created: String,
    val endDate: String,
    val endTime: String,
    val id: Int,
    val imageUrl: String,
    val isAvailable: Boolean,
    val location: String,
    val offerDescription: String,
    val offerName: String,
    val startTime: String,
    val updated: String
)
