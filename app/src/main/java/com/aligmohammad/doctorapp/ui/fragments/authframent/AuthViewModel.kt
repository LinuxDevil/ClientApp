package com.aligmohammad.doctorapp.ui.fragments.authframent

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aligmohammad.doctorapp.data.model.dto.UserLoginData
import com.aligmohammad.doctorapp.data.model.dto.VerifyDTO
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.repository.AuthRepository
import com.aligmohammad.doctorapp.data.network.responses.AuthResponse
import com.aligmohammad.doctorapp.data.network.responses.CurrentUserResponse
import com.aligmohammad.doctorapp.data.network.responses.User
import com.aligmohammad.doctorapp.data.network.responses.VerifyOTPResponse
import com.aligmohammad.doctorapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class AuthViewModel @ViewModelInject constructor(private val repository: AuthRepository) :
    BaseViewModel(repository) {

    private val _authResponse: MutableLiveData<Resource<AuthResponse>> = MutableLiveData()
    val authResponse: LiveData<Resource<AuthResponse>>
        get() = _authResponse

    private val _verifyResponse: MutableLiveData<Resource<VerifyOTPResponse>> = MutableLiveData()
    val verifyResponse: LiveData<Resource<VerifyOTPResponse>>
        get() = _verifyResponse

    private val _currentUserResponse: MutableLiveData<Resource<CurrentUserResponse>> =
        MutableLiveData()
    val currentUserResponse: LiveData<Resource<CurrentUserResponse>>
        get() = _currentUserResponse

    fun register(
        phoneNumber: String,
    ) = viewModelScope.launch {
        _authResponse.value = Resource.Loading
        _authResponse.value = repository.registerUser(UserLoginData(phoneNumber))
    }

    fun login(
        phoneNumber: String,
    ) = viewModelScope.launch {
        _authResponse.value = Resource.Loading
        _authResponse.value = repository.login(phoneNumber)
    }

    fun verify(phoneNumber: String, code: String) = viewModelScope.launch {
        _verifyResponse.value = Resource.Loading
        _verifyResponse.value = repository.verifyCode(VerifyDTO(phoneNumber, code))
    }

    fun getCurrentUserDetails(token: String) = viewModelScope.launch {
        _currentUserResponse.value = Resource.Loading
        _currentUserResponse.value = repository.getCurrentUser()
    }

    fun saveAccessTokens(accessToken: String, refreshToken: String) = viewModelScope.launch {
        repository.saveAuthToken(accessToken, refreshToken)
    }

    fun logoutUser() = viewModelScope.launch {
        repository.logoutUser()
    }

}