package com.aligmohammad.doctorapp.ui.dialogs.doctorconsulting.requestdoctornurse

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
import com.aligmohammad.doctorapp.databinding.RequestDoctorNurseBottomSheetFragmentBinding
import com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract
import com.aligmohammad.doctorapp.ui.dialogs.doctorconsulting.symptoms.SymptomsBottomSheetFragmentArgs
import com.aligmohammad.doctorapp.util.hideKeyboard
import com.aligmohammad.doctorapp.util.snackbar
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.request_doctor_nurse_bottom_sheet_fragment.view.*

class RequestDoctorNurseBottomSheetFragment : BottomSheetDialogFragment(), OnDialogInteract {

    private lateinit var viewModel: RequestDoctorNurseBottomSheetViewModel
    private lateinit var binding: RequestDoctorNurseBottomSheetFragmentBinding

    private var citySelected = ""
    private var districtSelected = ""
    private var majorSelected = ""
    private var selectedDoctorUuid = "0"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.request_doctor_nurse_bottom_sheet_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(RequestDoctorNurseBottomSheetViewModel::class.java)
        binding.viewModel = viewModel
        binding.listener = this

        binding.citiesSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val cities = resources.getStringArray(R.array.cities)
                citySelected = cities[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }
        binding.districtSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val districts = resources.getStringArray(R.array.amman_district)
                    districtSelected = districts[p2]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            }
        binding.insuranceCompanyTextViewSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val majors = resources.getStringArray(R.array.majors)
                    majorSelected = majors[p2]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            }

        binding.root.title.text = navArgs<RequestDoctorNurseBottomSheetFragmentArgs>().value.type

        binding.confirmButton.setOnClickListener {
            addUserAppointment()
        }

        return binding.root
    }

    override fun onBackButtonClicked(view: View) {
        this.dismiss()
    }


    private fun addUserAppointment() {
        // 1- Get user id
        val userId = UserSingleton.getCurrentUser().username
        // 2- Create appointment
    }


}