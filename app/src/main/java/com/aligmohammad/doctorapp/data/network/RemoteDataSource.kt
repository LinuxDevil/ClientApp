package com.aligmohammad.doctorapp.data.network

import android.content.Context
import com.aligmohammad.doctorapp.BuildConfig
import com.aligmohammad.doctorapp.data.network.api.TokenRefreshApi
import com.aligmohammad.doctorapp.helpers.PreferencesStore
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val preferences: PreferencesStore) {

    companion object {
//        private const val BASE_URL = "http://192.168.15.241:4000/api/"
        private const val BASE_URL = "http://192.168.1.12:4000/api/"
//        private const val BASE_URL = "http://10.234.15.43:4000/api/"
    }
    /*
    * This function will build the API
    * inside this function we are creating our TokenAuthenticator instance
    * */
    fun <Api> buildApi(
        api: Class<Api>,
        context: Context
    ): Api {
        val authenticator = TokenAuthenticator(context, buildTokenApi())
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getRetrofitClient(authenticator))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }

    /*
    * This function will build the TokenRefreshApi
    * I have a separate interface that contains only the
    * TokenRefresh endpoint and this function will build that api
    * */
    private fun buildTokenApi(): TokenRefreshApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getRetrofitClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TokenRefreshApi::class.java)
    }

    /*
    * This function will build our OkHttpClient
    * As we need it to intercept the request and add
    * required parameters
    * Also to add TokenAuthenticator, that will get the refresh token
    * we need this OkHttp Client
    * As you can see we are passing an Authenticator to the function
    * */
    private fun getRetrofitClient(authenticator: Authenticator? = null): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(chain.request().newBuilder().also {
                    it.addHeader("Accept", "application/json")
                }.build())
            }.also { client ->
                authenticator?.let { client.authenticator(it) }
                if (BuildConfig.DEBUG) {
                    val logging = HttpLoggingInterceptor()
                    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                    client.addInterceptor(logging)
                }
            }.build()
    }

}
