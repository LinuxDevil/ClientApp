/*******************************************************************************
 * Copyright Recticode(c) 2020.
 * All Rights Reserved
 *
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 *
 * Created by Ali Mohammad
 ******************************************************************************/

package com.aligmohammad.doctorapp.ui.dialogs.doctorconsulting.symptoms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.network.UserSingleton
import com.aligmohammad.doctorapp.databinding.SymptomsBottomSheetFragmentBinding
import com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract
import com.aligmohammad.doctorapp.util.hideKeyboard
import com.aligmohammad.doctorapp.util.snackbar
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SymptomsBottomSheetFragment : BottomSheetDialogFragment(), OnDialogInteract {

    private lateinit var viewModel: SymptomsBottomSheetViewModel
    private lateinit var binding: SymptomsBottomSheetFragmentBinding

    private var consultIn = ""
    private var temperatureSelected = ""
    private var selectedDoctorUuid = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.symptoms_bottom_sheet_fragment,
            container,
            false
        )
        getAllDoctors()

        viewModel = ViewModelProvider(this).get(SymptomsBottomSheetViewModel::class.java)
        binding.viewModel = viewModel
        binding.listener = this

        binding.symptomsSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val sympotoms = resources.getStringArray(R.array.spinner)
                    consultIn = sympotoms[p2]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            }

        return binding.root
    }

    private fun getAllDoctors() {
        val db = Firebase.database.reference
    }


    override fun onBackButtonClicked(view: View) {
        this.dismiss()
    }

    override fun onButtonClicked(view: View) {
        addUserAppointment()
    }

    private fun addUserAppointment() {
        temperatureSelected = binding.heatTempEditText.text.toString()

        // 1- Get user id
        val userId = UserSingleton.getCurrentUser().username
        // 2- Create appointment
    }

}