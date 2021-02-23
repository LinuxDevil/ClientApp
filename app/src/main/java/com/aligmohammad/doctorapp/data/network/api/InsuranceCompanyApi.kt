package com.aligmohammad.doctorapp.data.network.api

import com.aligmohammad.doctorapp.data.network.responses.*
import retrofit2.http.GET

interface InsuranceCompanyApi: BaseApi {

    @GET("/insurances")
    suspend fun getInsurances(): InsuranceCompanyResponse

}