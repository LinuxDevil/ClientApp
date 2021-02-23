package com.aligmohammad.doctorapp.data.network.api

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.POST

interface BaseApi {

    @POST("logout")
    suspend fun logout(): ResponseBody

}