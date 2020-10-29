package com.aligmohammad.doctorapp.data.api

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.core.content.getSystemService
import com.aligmohammad.doctorapp.util.NetworkException
import com.aligmohammad.doctorapp.util.NoInternetException
import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor(context: Context) : Interceptor {

    private val applicationContext = context.applicationContext;

    override fun intercept(chain: Interceptor.Chain): Response {
        if(!isConnected()) {
            throw NoInternetException("Please connect to the internet!")
        }
        return chain.proceed(chain.request())
    }


    private fun isConnected(): Boolean {
        var isAvailable = false;

        val connectivityManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

        connectivityManager?.let {
            it.getNetworkCapabilities(connectivityManager.activeNetwork)?.apply {
                isAvailable = when {
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    else -> false
                }
            }
        }
        return isAvailable
    }

}