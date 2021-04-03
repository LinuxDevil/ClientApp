package com.aligmohammad.doctorapp.ui.dialogs.operationschoice

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aligmohammad.doctorapp.data.model.nest.AddAppointment
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.repository.HospitalRepository
import com.aligmohammad.doctorapp.data.network.responses.AppointmentResponse
import com.aligmohammad.doctorapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class OpertaionBottomSheetViewModel @ViewModelInject constructor(private val hospitalRepository: HospitalRepository) :
    BaseViewModel(hospitalRepository) {

    private val _addAppointmentResponse: MutableLiveData<Resource<AppointmentResponse>> =
        MutableLiveData()
    val addAppointmentResponse: LiveData<Resource<AppointmentResponse>>
        get() = _addAppointmentResponse

    fun addHospitalDoctorAppointment(appointment: AddAppointment) = viewModelScope.launch {
        _addAppointmentResponse.value = Resource.Loading
        _addAppointmentResponse.value = hospitalRepository.addHospitalDoctorAppointment(appointment)
    }

}