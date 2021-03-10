package com.aligmohammad.doctorapp.ui.dialogs.governmentchoice

import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.repository.HospitalRepository
import com.aligmohammad.doctorapp.data.network.response.HospitalResponse
import com.aligmohammad.doctorapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class GovernmentHospitalChoiceViewModel @ViewModelInject constructor(private val hospitalRepository: HospitalRepository) :
    BaseViewModel(hospitalRepository) {

    private val _hospitalResponse: MutableLiveData<Resource<HospitalResponse>> = MutableLiveData()
    val hospitalResponse: LiveData<Resource<HospitalResponse>>
        get() = _hospitalResponse

    fun getHospitals() = viewModelScope.launch {
        _hospitalResponse.value = Resource.Loading
        _hospitalResponse.value = hospitalRepository.getPrivateHospitals()
    }

    fun getGovernmentHospitals() = viewModelScope.launch {
        _hospitalResponse.value = Resource.Loading
        _hospitalResponse.value = hospitalRepository.getGeneralHospitals()
    }

    fun getFilteredHospitals(cityId: String) = viewModelScope.launch {
        _hospitalResponse.value = Resource.Loading
        _hospitalResponse.value = hospitalRepository.getFilteredPrivateHospitals(cityId)
    }

    fun getFilteredGeneralHospitals(cityId: String) = viewModelScope.launch {
        _hospitalResponse.value = Resource.Loading
        _hospitalResponse.value = hospitalRepository.getFilteredGeneralHospitals(cityId)
    }

    fun onConfirmClicked(view: View) {
        Navigation.findNavController(view)
            .navigate(GovernmentHospitalChoiceDirections.govChoiceToGovHospitals(null))
    }

}