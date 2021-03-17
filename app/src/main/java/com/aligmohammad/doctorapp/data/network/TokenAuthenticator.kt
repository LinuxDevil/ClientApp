package com.aligmohammad.doctorapp.data.network

import android.content.Context
import android.util.Log
import com.aligmohammad.doctorapp.data.network.api.AuthToken
import com.aligmohammad.doctorapp.data.network.api.TokenRefreshApi
import com.aligmohammad.doctorapp.data.network.repository.BaseRepository
import com.aligmohammad.doctorapp.data.network.responses.TokenResponse
import com.aligmohammad.doctorapp.helpers.PreferencesStore
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
    private val context: Context,
    private val api: TokenRefreshApi
) : Authenticator, BaseRepository(api) {

    private val appContext = context.applicationContext
    private val userPreferences = PreferencesStore(appContext)

    override fun authenticate(route: Route?, response: Response): Request? {
        Log.v("Auth", "Inside Authenticate")
        val tokenResponse = getToken()
        Log.v("Auth", "Authenticate ${tokenResponse}")

        return when (val tokenResponse = getToken()) {
            is Resource.Success -> {
                if (tokenResponse.value.token != null) {
                    saveToken(tokenResponse.value.token)
                    return response.request.newBuilder()
                        .header("Authorization", "Token ${tokenResponse.value.token}")
                        .build()
                }
                return null
            }
            else -> null
        }

//        if (tokenResponse.()) {
//            return response.request.newBuilder()
//                .header("Authorization", "Token $tokenResponse")
//                .build()
//        } else {
//            return null
//        }
    }

    private fun saveToken(tokenResponse: String) = runBlocking {
        userPreferences.saveAccessTokens(
            tokenResponse,
            tokenResponse
        )
    }

    private fun getToken() = runBlocking {
        Log.v("Auth", "runBlocking")
        getUpdatedTokenUser()
    }

    private suspend fun getUpdatedToken(): String {
        var refreshToken: String = ""
        Log.v("Auth", "getUpdatedToken")
        GlobalScope.launch {
            userPreferences.accessToken.collect {
                Log.v("Auth", "Collecting ${it}")
                refreshToken = it!!
            }
        }
        Log.v("Auth", refreshToken)
        return refreshToken
    }

    private suspend fun getUpdatedTokenUser(): Resource<TokenResponse> {
        val user = userPreferences.accessToken.first()
        return safeApiCall { api.refreshAccessToken(AuthToken(user)) }
    }


}