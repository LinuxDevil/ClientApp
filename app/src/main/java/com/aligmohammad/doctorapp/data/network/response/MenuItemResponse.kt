package com.aligmohammad.doctorapp.data.network.response

import com.google.gson.annotations.SerializedName

data class MenuItemResponse(
    @SerializedName("menuArray")
    val menuItems: ArrayList<MenuItemResponseItem>
)

data class MenuItemResponseItem(
    val created: String,
    val id: Int,
    val image_url: String? = "",
    val isAvailable: Boolean,
    val isUser: Boolean,
    val nameAr: String,
    val nameEn: String,
    val updated: String
)