package com.aligmohammad.doctorapp.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aligmohammad.doctorapp.data.network.repository.AuthRepository
import com.aligmohammad.doctorapp.data.network.repository.BaseRepository
import com.aligmohammad.doctorapp.ui.fragments.authframent.AuthViewModel

class ViewModelFactory(private val repository: BaseRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T
            else -> throw IllegalArgumentException("ViewModel Class Not Found!")
        }
    }
}