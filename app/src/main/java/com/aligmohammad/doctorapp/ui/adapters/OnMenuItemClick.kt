



package com.aligmohammad.doctorapp.ui.adapters

import android.util.Log
import android.view.View
import com.aligmohammad.doctorapp.data.model.firebasemodels.MajorsFirebaseModel
import com.aligmohammad.doctorapp.data.model.firebasemodels.OfferFirebaseModel

interface OnMenuItemClick {

    fun onClick(v: View)

    fun onClickMenu(v: View?, menuItem: MajorsFirebaseModel) {
        Log.v("OnMenuItemClick", "Clicked on ${menuItem.name_en}")
    }
    fun onClickMenu(v: View?, menuItem: OfferFirebaseModel) {
        Log.v("OnMenuItemClick", "Clicked on ${menuItem.offerName}")
    }

}