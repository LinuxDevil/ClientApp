package com.aligmohammad.doctorapp.data.model.nest

data class AddAppointment(
    var date: String?,
    var time: String?,
    var location: String?,
    var shift: String?,
    var user: String?,
    var doctor: String?,
    var place: String?,
    var hospitalId: String?,
    var type: String?,
    var tests: String? = null
)
