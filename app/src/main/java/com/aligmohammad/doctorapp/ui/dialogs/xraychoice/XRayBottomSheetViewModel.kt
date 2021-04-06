package com.aligmohammad.doctorapp.ui.dialogs.xraychoice

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aligmohammad.doctorapp.data.model.dto.AppointmentDTO
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.repository.HospitalRepository
import com.aligmohammad.doctorapp.data.network.responses.HospitalAppointment
import com.aligmohammad.doctorapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class XRayBottomSheetViewModel @ViewModelInject constructor(private val hospitalRepository: HospitalRepository) :
    BaseViewModel(hospitalRepository) {

    private val _addAppointmentResponse: MutableLiveData<Resource<HospitalAppointment>> =
        MutableLiveData()
    val addAppointmentResponse: LiveData<Resource<HospitalAppointment>>
        get() = _addAppointmentResponse

    fun addGeneralHospitalDoctorAppointment(appointment: AppointmentDTO) = viewModelScope.launch {
        _addAppointmentResponse.value = Resource.Loading
        _addAppointmentResponse.value =
            hospitalRepository.addGeneralHospitalAppointment(appointment)
    }

}