package com.aligmohammad.doctorapp.data.network.api

import com.aligmohammad.doctorapp.data.network.responses.MenuItemResponse
import retrofit2.http.GET


interface MenuApi: BaseApi {

    @GET("/api/menuitems/user")
    suspend fun getMenuItems(): MenuItemResponse

    @GET("/api/menuitems/sub")
    suspend fun getSubMenuItems(): MenuItemResponse

}