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

import com.aligmohammad.doctorapp.data.model.User
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthApi {

    @Headers("Content-Type: application/json")
    @POST("/login")
    suspend fun login(@Body user: User): Response

    @Headers("Content-Type: application/json")
    @POST("/register")
    suspend fun register(@Body user: User): Response

    @Headers("Content-Type: application/json")
    @POST("/phone_code")
    suspend fun register(@Body number: String): Response

    companion object {
        operator fun invoke(networkInterceptor: NetworkInterceptor): AuthApi {
            return Retrofit.Builder()
                .client(OkHttpClient.Builder().addInterceptor(networkInterceptor).build())
                .baseUrl("https://www.google.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(AuthApi::class.java)
        }
    }

}