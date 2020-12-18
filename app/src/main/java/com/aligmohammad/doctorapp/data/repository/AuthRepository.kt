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

package com.aligmohammad.doctorapp.data.repository

import com.aligmohammad.doctorapp.data.api.ApiService
import com.aligmohammad.doctorapp.data.api.AuthApi
import com.aligmohammad.doctorapp.data.database.AppDatabase

class AuthRepository(private val api: AuthApi, private val database: AppDatabase) : ApiService() {

    suspend fun registerUser(username: String, phoneNumber: String) {

    }

}