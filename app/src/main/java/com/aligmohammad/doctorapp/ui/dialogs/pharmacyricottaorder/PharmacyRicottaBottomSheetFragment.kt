/*******************************************************************************
 * Copyright RectiCode(c) 2020.
 * All Rights Reserved
 *
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and de-compilation.
 *
 * Created by Ali Mohammad
 ******************************************************************************/

package com.aligmohammad.doctorapp.ui.dialogs.pharmacyricottaorder

//lujainbattikhi@gmail.com

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.dto.PharmacyOrder
import com.aligmohammad.doctorapp.data.network.UserSingleton
import com.aligmohammad.doctorapp.databinding.PharmacyRicottaBottomSheetFragmentBinding
import com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract
import com.aligmohammad.doctorapp.ui.dialogs.labschoice.LabsBottomSheetFragmentArgs
import com.aligmohammad.doctorapp.util.hideKeyboard
import com.aligmohammad.doctorapp.util.snackbar
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class PharmacyRicottaBottomSheetFragment : BottomSheetDialogFragment(), OnDialogInteract {

    private lateinit var viewModel: PharmacyRicottaBottomSheetViewModel
    private lateinit var binding: PharmacyRicottaBottomSheetFragmentBinding

    private var medicineSelected = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.pharmacy_ricotta_bottom_sheet_fragment,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(PharmacyRicottaBottomSheetViewModel::class.java)
        binding.viewModel = viewModel
        binding.listener = this

        binding.medicineSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val medicineAvailable = resources.getStringArray(R.array.spinner)
                    medicineSelected = medicineAvailable[p2]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }

        binding.confirmButton.setOnClickListener {
            addUserAppointment()
        }

        return binding.root
    }

    override fun onBackButtonClicked(view: View) {
        dismiss()
    }

    private fun addUserAppointment() {
        if (medicineSelected.isEmpty()) {
            val medicineAvailable = resources.getStringArray(R.array.spinner)
            medicineSelected = medicineAvailable[0]
        }
        // 1- Get user id
        val userId = UserSingleton.getCurrentUser().username
        // 2- Create appointment
        val order = PharmacyOrder(
            medicineSelected,
            userId,
            navArgs<LabsBottomSheetFragmentArgs>().value.placeUuid,
        )
        // 3- Push Appointment to db
        val database = Firebase.database.reference
        val orderUuid = database.push().key
        if (orderUuid != null) {
            hideKeyboard()
        }

    }


}