/*******************************************************************************
 * Copyright Recticode(c) 2020.
 * All Rights Reserved
 *
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 *
 * Created by Ali Mohammad
 ******************************************************************************/

package com.aligmohammad.doctorapp.ui.fragments.doctorconsultingresult

import androidx.lifecycle.ViewModel
import com.aligmohammad.doctorapp.data.model.Medicine

class DoctorConsultResultFragmentViewModel : ViewModel() {
    fun getMedicine(): List<Medicine> {

        val medicineList = arrayListOf<Medicine>()
        medicineList.add(Medicine("Panadol Extra", 11, " JD"))
        medicineList.add(Medicine("Vitamin C", 9,  " JD"))
        medicineList.add(Medicine("Eye Drops", 1,  " JD"))

        return medicineList
    }
}