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
import com.aligmohammad.doctorapp.data.model.Doctor
import com.aligmohammad.doctorapp.data.model.firebasemodels.ConsultationFirebaseModel
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
        db.child("Doctors").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.children.forEach { snap ->
                    val doctor: Doctor = snap.getValue(Doctor::class.java)!!
                    if (navArgs<SymptomsBottomSheetFragmentArgs>().value.city!!.isNotEmpty()) {
                        if (doctor.city!!.indexOf(navArgs<SymptomsBottomSheetFragmentArgs>().value.city!!) != -1) {
                            if (doctor.district!!.indexOf(navArgs<SymptomsBottomSheetFragmentArgs>().value.district!!) != -1) {
                                if (doctor.insuranceCompany!!.indexOf(navArgs<SymptomsBottomSheetFragmentArgs>().value.insuranceName!!) != -1) {
                                    selectedDoctorUuid = doctor.uuid!!
                                }
                            }
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                binding.heatTempEditText.snackbar(error.message)
                dismiss()
            }
        })
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
        val appointment = ConsultationFirebaseModel(
            consultIn,
            temperatureSelected,
            userId,
            navArgs<SymptomsBottomSheetFragmentArgs>().value.city,
            navArgs<SymptomsBottomSheetFragmentArgs>().value.district,
            selectedDoctorUuid
        )
        // 3- Push Appointment to db
        val database = Firebase.database.reference
        val appointmentUuid = database.push().key
        if (appointmentUuid != null) {
            hideKeyboard()
            database.child("Consultation").child(appointmentUuid).setValue(appointment)
                .addOnCompleteListener {
                    // 4- Add appointment id to user
                    // 5- Push user changes
                    database.child("Users").child(userId!!.substring(1, userId!!.length))
                        .child("Consultation").child(appointmentUuid).setValue(appointmentUuid)
                        .addOnCompleteListener {
                            database.child("Doctors")
                                .child(selectedDoctorUuid)
                                .child("Consultation").child(appointmentUuid)
                                .setValue(appointmentUuid)
//                            val navController =
//                                Navigation.findNavController(activity!!, R.id.fragment)
//                            if (navController.currentDestination!!.id == R.id.symptomsFragment) {
//                                this.navigateSafe(SymptomsBottomSheetFragmentDirections.symptomsToResult())
//                            }
                            dismiss()
                        }.addOnFailureListener {
                            binding.heatTempEditText.snackbar(it.localizedMessage)
                            dismiss()
                        }
                }.addOnFailureListener {
                    binding.heatTempEditText.snackbar(it.localizedMessage)
                    dismiss()
                }
        }

    }


}