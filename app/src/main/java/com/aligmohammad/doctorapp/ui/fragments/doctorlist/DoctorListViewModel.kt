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

package com.aligmohammad.doctorapp.ui.fragments.doctorlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aligmohammad.doctorapp.data.model.Doctor
import com.aligmohammad.doctorapp.data.model.Place

class DoctorListViewModel : ViewModel() {

    lateinit var doctorListLiveData: MutableLiveData<List<Doctor>>

    fun getLabs(): ArrayList<Place> {
        val labList = arrayListOf<Place>()

        labList.add(
            Place(
                "",
                "",
                "",
                "",
                "https://medicalentitystorageprod.blob.core.windows.net/157544/Profile/passport_df603e88-10a4-455b-a0dc-0db8b68c6d2d.jpeg",
                "Amman, Jordan",
                1,
                2,
                4,
                "Mega Labs"
            )
        )
        labList.add(
            Place(
                "",
                "",
                "",
                "",
                "https://media.glassdoor.com/sqll/658249/omega-laboratories-squarelogo-1524436963939.png",
                "Ma\'an, Jordan",
                4,
                2,
                4,
                "Omega Labs"
            )
        )
        labList.add(
            Place(
                "",
                "",
                "",
                "",
                "https://www.360moms.net/sites/default/files/offers/biolab.jpg",
                "Amman, Jordan",
                2,
                2,
                4,
                "Biolab"
            )
        )
        labList.add(
            Place(
                "",
                "",
                "",
                "",
                "https://www.360moms.net/sites/default/files/offers/Medlabs_0.jpg",
                "Zarga, Jordan",
                3,
                2,
                4,
                "medlabs"
            )
        )

        return labList
    }

    fun getXRays(): ArrayList<Place> {
        val labList = arrayListOf<Place>()

        labList.add(
            Place(
                "",
                "",
                "",
                "",
                "https://media-exp1.licdn.com/dms/image/C560BAQFVBiQXoVRauQ/company-logo_200_200/0?e=2159024400&v=beta&t=9HGjbEZdSeYEfWuLFIM88NfSLjCoVPIuCqMrks8DlmI",
                "Amman, Jordan",
                4,
                20,
                5,
                "Medray"
            )
        )
        labList.add(
            Place(
                "",
                "",
                "",
                "",
                "https://medicalentitystorageprod.blob.core.windows.net/18906/Profile/passport_7918d6af-1e68-4985-bbdc-f6821e7aca03.jpg",
                "Ma\'an, Jordan",
                5,
                2,
                4,
                "My Ray"
            )
        )

        return labList
    }

    fun getXPharmacies(): ArrayList<Place> {
        val labList = arrayListOf<Place>()

        labList.add(
            Place(
                "",
                "",
                "",
                "",
                "https://pharmacy-one.com/images/fbCover.png",
                "Amman, Jordan",
                4,
                6,
                4,
                "Pharmacy One"
            )
        )
        labList.add(
            Place(
                "",
                "",
                "",
                "",
                "https://www.tipntag.com/files/get/original/place/_5315b4cedb35e8.01027749_rawhipharmacy.jpg",
                "Ma\'an, Jordan",
                3,
                2,
                0,
                "Rawhi Pharmacy"
            )
        )

        return labList
    }

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