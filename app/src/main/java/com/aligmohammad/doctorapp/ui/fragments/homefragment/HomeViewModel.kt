package com.aligmohammad.doctorapp.ui.fragments.homefragment

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.aligmohammad.doctorapp.BaseViewModel
import com.aligmohammad.doctorapp.data.model.RecyclerMenuItem
import com.aligmohammad.doctorapp.ui.fragments.insurancefragment.InsuranceFragmentDirections

class HomeViewModel(application: Application) : BaseViewModel(application) {

    val menuItems by lazy { MutableLiveData<ArrayList<RecyclerMenuItem>>() }
    val imageUrl = "https://images.pexels.com/photos/5591890/pexels-photo-5591890.jpeg"
    fun setMenuItems(list: ArrayList<RecyclerMenuItem>) {
        menuItems.value = list
    }

    fun dummyList(): ArrayList<RecyclerMenuItem> {
        val arrayList = arrayListOf<RecyclerMenuItem>()
        arrayList.add(RecyclerMenuItem("Government Hospitals", "https://images.pexels.com/photos/4047184/pexels-photo-4047184.jpeg", InsuranceFragmentDirections.insuracneToHome()))
        arrayList.add(RecyclerMenuItem("Private Hospitals", "https://images.pexels.com/photos/4386467/pexels-photo-4386467.jpeg", InsuranceFragmentDirections.insuracneToHome()))
        arrayList.add(RecyclerMenuItem("Specialists Doctors", "https://images.pexels.com/photos/3957986/pexels-photo-3957986.jpeg", InsuranceFragmentDirections.insuracneToHome()))
        arrayList.add(RecyclerMenuItem("General Doctors", "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg", InsuranceFragmentDirections.insuracneToHome()))
        arrayList.add(RecyclerMenuItem("X-Rays", "https://images.pexels.com/photos/4225923/pexels-photo-4225923.jpeg", InsuranceFragmentDirections.insuracneToHome()))
        arrayList.add(RecyclerMenuItem("Labs", "https://images.pexels.com/photos/356040/pexels-photo-356040.jpeg", InsuranceFragmentDirections.insuracneToHome()))
        arrayList.add(RecyclerMenuItem("Pharmacies", "https://images.pexels.com/photos/4210617/pexels-photo-4210617.jpeg", InsuranceFragmentDirections.insuracneToHome()))
        arrayList.add(RecyclerMenuItem("Doctor consultation", "https://images.pexels.com/photos/4167541/pexels-photo-4167541.jpeg", InsuranceFragmentDirections.insuracneToHome()))
        return arrayList
    }

}