package com.aligmohammad.doctorapp.ui.dialogs.governmentchoice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.responses.HospitalResponseItem
import com.aligmohammad.doctorapp.databinding.BottomSheetGovernmentHospitalChooseBinding
import com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.bottom_sheet_government_hospital_choose.view.*

@AndroidEntryPoint
class GovernmentHospitalChoice : BottomSheetDialogFragment(), OnDialogInteract {

    private val viewModel by viewModels<GovernmentHospitalChoiceViewModel>()
    private var hospitalNames = ArrayList<HospitalResponseItem>()
    private var selectedIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: BottomSheetGovernmentHospitalChooseBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.bottom_sheet_government_hospital_choose,
            container,
            false
        )
        binding.listener = this
        binding.viewModel = viewModel

        if (arguments?.getString("type") === "General hospitals") {
            viewModel.getFilteredGeneralHospitals("1")
        } else {
            viewModel.getFilteredHospitals("1")
        }

        binding.citiesSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val cityId = p2 + 1
                if (arguments?.getString("type") === "General hospitals") {
                    viewModel.getFilteredGeneralHospitals(cityId.toString())
                } else {
                    viewModel.getFilteredHospitals(cityId.toString())
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }


        binding.hospitalsSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    selectedIndex = p2
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            }

        viewModel.hospitalResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    hospitalNames = it.value.hospitals
                    if (it.value.length!! >= 1) {
                        val hospitalNameStrings = it.value.hospitalNames
                        binding.hospitalsSpinner.adapter = ArrayAdapter(
                            requireContext(),
                            android.R.layout.simple_dropdown_item_1line,
                            hospitalNameStrings
                        )
                    } else {
                        Toast.makeText(requireContext(), "There is no hospitals", Toast.LENGTH_LONG)
                            .show()
                    }
                }
                is Resource.Failure -> {

                }
                is Resource.Loading -> {

                }
            }
        })

        val title = arguments?.getString("type")
        binding.root.title.text = title
        binding.confirmButton.setOnClickListener {
            if (title === "General hospitals") {
                Navigation.findNavController(requireActivity(), R.id.fragment).navigate(
                    GovernmentHospitalChoiceDirections.govChoiceToGovHospitals(hospitalNames[selectedIndex])
                )
            } else {
                Navigation.findNavController(requireActivity(), R.id.fragment).navigate(
                    GovernmentHospitalChoiceDirections.govChoiceToPrivateHospitals(hospitalNames[selectedIndex])
                )
            }
        }
        return binding.root
    }

    fun onConfirmClicked(view: View) {
    }

    override fun onBackButtonClicked(view: View) {
        this.dismiss()
    }

}