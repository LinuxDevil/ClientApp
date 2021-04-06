package com.aligmohammad.doctorapp.ui.fragments.authframent

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aligmohammad.doctorapp.data.model.dto.UserDTO
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.repository.UserRepository
import com.aligmohammad.doctorapp.data.network.responses.UserInfoResponse
import com.aligmohammad.doctorapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class NationalIDViewModel @ViewModelInject constructor(private val repository: UserRepository) :
    BaseViewModel(repository) {

    private val _userInfoResponse: MutableLiveData<Resource<UserInfoResponse>> = MutableLiveData()
    val userResponse: LiveData<Resource<UserInfoResponse>>
        get() = _userInfoResponse

    fun updateUser(userDto: UserDTO) = viewModelScope.launch {
        _userInfoResponse.value = Resource.Loading
        _userInfoResponse.value = repository.updateUser(userDto)
    }

}