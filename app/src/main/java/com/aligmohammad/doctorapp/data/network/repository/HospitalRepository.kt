package com.aligmohammad.doctorapp.data.network.repository

import com.aligmohammad.doctorapp.data.network.api.BaseApi
import javax.inject.Inject

class HospitalRepository @Inject constructor(
    api: BaseApi
): BaseRepository(api) {
}