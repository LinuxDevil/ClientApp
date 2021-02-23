package com.aligmohammad.doctorapp.data.model.firebasemodels

data class PharmacyOrder(
    var userId: String?,
    var placeId: String?,
    var medicine: String?,
    var pictureUrl: String?
) {
    constructor() : this("", "", "", "")
}