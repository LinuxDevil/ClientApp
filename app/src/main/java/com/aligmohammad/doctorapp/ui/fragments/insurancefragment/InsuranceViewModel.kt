package com.aligmohammad.doctorapp.ui.fragments.insurancefragment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aligmohammad.doctorapp.data.model.dto.UserInfoModel
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.repository.HomeRepository
import com.aligmohammad.doctorapp.data.network.responses.InsuranceCompanyResponse
import com.aligmohammad.doctorapp.data.network.responses.UserInfoResponse
import com.aligmohammad.doctorapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class InsuranceViewModel @ViewModelInject constructor(private val repository: HomeRepository) :
    BaseViewModel(repository) {

    private val _insuranceResponse: MutableLiveData<Resource<InsuranceCompanyResponse>> =
        MutableLiveData()
    val insuranceResponse: LiveData<Resource<InsuranceCompanyResponse>>
        get() = _insuranceResponse

    private val _addInsuranceResponse: MutableLiveData<Resource<UserInfoResponse>> = MutableLiveData()
    val addInsuranceResponse: LiveData<Resource<UserInfoResponse>> get() = _addInsuranceResponse

    fun getInsuranceCompanies() = viewModelScope.launch {
        _insuranceResponse.value = repository.getInsuranceCompanyApi()
    }

    fun updateUserInfo(userInfo: UserInfoModel) = viewModelScope.launch {
        _addInsuranceResponse.value = repository.addUserInfo(userInfo)
    }


}