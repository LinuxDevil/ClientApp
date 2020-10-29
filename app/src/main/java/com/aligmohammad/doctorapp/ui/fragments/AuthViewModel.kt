package com.aligmohammad.doctorapp.ui.fragments

import android.app.Application
import android.content.Context
import com.aligmohammad.doctorapp.data.repository.AuthRepository
import com.aligmohammad.doctorapp.ui.base.BaseViewModel

class AuthViewModel(private val repository: AuthRepository, application: Application): BaseViewModel(application) {
}