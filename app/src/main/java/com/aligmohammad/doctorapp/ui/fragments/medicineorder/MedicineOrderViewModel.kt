package com.aligmohammad.doctorapp.ui.fragments.medicineorder

import androidx.lifecycle.ViewModel
import com.aligmohammad.doctorapp.data.model.Medicine

class MedicineOrderViewModel : ViewModel() {
    fun getMedicine(): List<Medicine> {

        val medicineList = arrayListOf<Medicine>()
        medicineList.add(Medicine("Panadol Extra", 5, " JD"))
        medicineList.add(Medicine("Vitamin C", 2, " JD"))
        medicineList.add(Medicine("Eye Drops", 1, " JD"))

        return medicineList
    }
}