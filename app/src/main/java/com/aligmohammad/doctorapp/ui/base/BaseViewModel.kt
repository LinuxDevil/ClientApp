package com.aligmohammad.doctorapp.ui.base

import androidx.lifecycle.ViewModel
import com.aligmohammad.doctorapp.data.network.repository.BaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class BaseViewModel(private val repository: BaseRepository) : ViewModel() {

    suspend fun logout() = withContext(Dispatchers.IO) { repository.logout() }

}