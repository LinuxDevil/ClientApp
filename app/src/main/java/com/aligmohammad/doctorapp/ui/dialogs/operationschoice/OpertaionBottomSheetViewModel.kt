package com.aligmohammad.doctorapp.ui.dialogs.operationschoice

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.aligmohammad.doctorapp.data.network.repository.HospitalRepository
import com.aligmohammad.doctorapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class OpertaionBottomSheetViewModel @ViewModelInject constructor(private val hospitalRepository: HospitalRepository) :
    BaseViewModel(hospitalRepository) {

        fun getDoctors() = viewModelScope.launch {
            hospitalRepository.getPrivateHospitals()
        }

}