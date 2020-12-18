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

import com.aligmohammad.doctorapp.util.ApiException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response


abstract class ApiService {

    suspend fun<T: Any> apiRequest(call: suspend (() -> Response<T>)): T {
        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body()!!
        }
        val error = response.errorBody()?.string()
        val message = StringBuilder()
        error?.let {
            try {
                message.append(JSONObject(it).getString("message"))
            } catch (error: JSONException) {

            }
            message.append("\n")
        }
        message.append("Error code ${response.code()}")
        throw ApiException(message.toString())
    }

}