/*******************************************************************************
 *
 * Copyright RectiCode(c) 2020.
 * All Rights Reserved
 *
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and de-compilation.
 *
 * Created by Ali Mohammad
 *
 ******************************************************************************/

/*******************************************************************************
 *
 * Copyright RectiCode(c) 2020.
 * All Rights Reserved
 *
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and de-compilation.
 *
 * Created by Ali Mohammad
 *
 ******************************************************************************/

package com.aligmohammad.doctorapp.data.api

import com.aligmohammad.doctorapp.data.model.Doctor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers


interface DoctorApi {

    @GET("/doctors/all")
    suspend fun getAllDoctors(): List<Doctor>

    @Headers("Content-Type: application/json")
    @GET("/doctors/getById")
    suspend fun getDoctorById(@Body id: String): Doctor

    companion object {
        operator fun invoke(networkInterceptor: NetworkInterceptor): DoctorApi {
            return Retrofit.Builder()
                .client(OkHttpClient.Builder().addInterceptor(networkInterceptor).build())
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(DoctorApi::class.java)
        }
    }

}