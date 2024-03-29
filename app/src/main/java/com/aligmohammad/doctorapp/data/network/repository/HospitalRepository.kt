package com.aligmohammad.doctorapp.data.network.repository

import com.aligmohammad.doctorapp.data.model.dto.AppointmentDTO
import com.aligmohammad.doctorapp.data.network.api.HospitalApi
import javax.inject.Inject

class HospitalRepository @Inject constructor(
    private val api: HospitalApi
) : BaseRepository(api) {

    suspend fun getPrivateHospitals(langId: String) = safeApiCall {
        api.getPrivateHospitals(langId)
    }

    suspend fun getGeneralHospitals(langId: String) = safeApiCall {
        api.getGeneralHospitals(langId)
    }

    suspend fun getFilteredPrivateHospitals(city: String, langId: String) = safeApiCall {
        api.getFilteredPrivateHospitals(city, langId)
    }

    suspend fun getFilteredGeneralHospitals(city: String, langId: String) = safeApiCall {
        api.getFilteredGenernalHospitals(city, langId)
    }

    suspend fun addHospitalDoctorAppointment(addAppointment: AppointmentDTO) = safeApiCall {
        api.addHospitalDoctorAppointment(addAppointment)
    }

    suspend fun addGeneralHospitalAppointment(addAppointment: AppointmentDTO) = safeApiCall {
        api.addHospitalAppointment(addAppointment)
    }

}