package com.aligmohammad.doctorapp.data.network.responses

import com.aligmohammad.doctorapp.data.model.Status
import com.google.gson.annotations.SerializedName

data class MenuItemResponse(
    val length: Int,
    @SerializedName("menuArray")
    val menuItems: List<MenuItemResponseItem>,
    val menuItemNames: List<String>,
    val status: Status
)

data class MenuItemResponseItem(
    val created: String,
    val id: Int,
    val image_url: String,
    val isAvailable: Boolean,
    val isSub: Boolean,
    val isUser: Boolean,
    val nameAr: String,
    val nameEn: String,
    val updated: String
)
