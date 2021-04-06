package com.aligmohammad.doctorapp.data.network.api

import com.aligmohammad.doctorapp.data.network.responses.GetInsuranceResponse
import retrofit2.http.GET

interface InsuranceCompanyApi : BaseApi {

    @GET("/api/insurance")
    suspend fun getInsurances(): GetInsuranceResponse

}