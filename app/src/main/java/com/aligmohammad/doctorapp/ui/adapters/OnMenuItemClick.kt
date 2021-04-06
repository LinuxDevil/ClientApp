package com.aligmohammad.doctorapp.ui.adapters

import android.util.Log
import android.view.View
import com.aligmohammad.doctorapp.data.network.responses.Major
import com.aligmohammad.doctorapp.data.network.responses.MenuItemResponseItem
import com.aligmohammad.doctorapp.data.network.responses.Offer

interface OnMenuItemClick {

    fun onClick(v: View)

    fun onClickMenu(v: View?, menuItem: MenuItemResponseItem) {
        Log.v("OnMenuItemClick", "Clicked on ${menuItem.nameEn}")
    }

    fun onClickMenu(v: View?, menuItem: Offer) {
        Log.v("OnMenuItemClick", "Clicked on ${menuItem.offerName}")
    }

    fun onClickMenu(v: View?, menuItem: Major) {
        Log.v("OnMenuItemClick", "Clicked on ${menuItem.nameEn}")
    }

}