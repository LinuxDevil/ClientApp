package com.aligmohammad.doctorapp.ui.fragments.doctorlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aligmohammad.doctorapp.data.model.Doctor

class DoctorListViewModel : ViewModel() {

    lateinit var doctorListLiveData: MutableLiveData<List<Doctor>>

    fun getDoctorList(): ArrayList<Doctor> {
        val doctorList = arrayListOf<Doctor>()
        doctorList.add(
            Doctor(
                "Ali Mohammad",
                "https://images.pexels.com/photos/3279197/pexels-photo-3279197.jpeg",
                1,
                "Heart",
                2,
                "",
                listOf("NatHealth"),
                "Amman, Jordan",
                34.1f,
                35f
            )
        )
        doctorList.add(
            Doctor(
                "Canaan Mohammad",
                "https://images.pexels.com/photos/3985178/pexels-photo-3985178.jpeg",
                4,
                "X-Ray",
                2,
                "",
                listOf("NatHealth"),
                "Irbid, Jordan",
                34.1f,
                35f
            )
        )
        doctorList.add(
            Doctor(
                "Ahmad Mohammad",
                "https://images.pexels.com/photos/3845735/pexels-photo-3845735.jpeg",
                3,
                "Ears",
                2,
                "",
                listOf("NatHealth"),
                "Zarga, Jordan",
                34.1f,
                35f
            )
        )
        doctorList.add(
            Doctor(
                "Ghassan Mohammad",
                "https://images.pexels.com/photos/4173239/pexels-photo-4173239.jpeg",
                5,
                "Bones",
                2,
                "",
                listOf("NatHealth"),
                "Ma\'an, Jordan",
                34.1f,
                35f
            )
        )
        doctorList.add(
            Doctor(
                "Osama Mohammad",
                "https://images.pexels.com/photos/5434019/pexels-photo-5434019.jpeg",
                4,
                "Vitamin",
                2,
                "",
                listOf("NatHealth"),
                "Amman, Jordan",
                34.1f,
                35f
            )
        )
        doctorList.add(
            Doctor(
                "Tareq Mohammad",
                "https://images.pexels.com/photos/2182979/pexels-photo-2182979.jpeg",
                2,
                "Legs",
                2,
                "",
                listOf("NatHealth"),
                "Amman, Jordan",
                34.1f,
                35f
            )
        )

//        doctorListLiveData.value = doctorList
        return doctorList
    }

}