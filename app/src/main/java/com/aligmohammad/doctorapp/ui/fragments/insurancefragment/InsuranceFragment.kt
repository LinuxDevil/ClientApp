package com.aligmohammad.doctorapp.ui.fragments.insurancefragment

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.UserInfoModel
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.UserSingleton
import com.aligmohammad.doctorapp.databinding.InsuranceFragmentBinding
import com.aligmohammad.doctorapp.ui.fragments.authframent.NationalIDFragmentDirections
import com.aligmohammad.doctorapp.util.handleApiError
import com.aligmohammad.doctorapp.util.hideKeyboard
import com.aligmohammad.doctorapp.util.snackbar
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import navigateSafe

@AndroidEntryPoint
class InsuranceFragment : Fragment(R.layout.insurance_fragment), AdapterView.OnItemSelectedListener {
    private lateinit var binding: InsuranceFragmentBinding
    private val viewModel by viewModels<InsuranceViewModel>()

    private var itemSelected = ""

    private var insuranceMenu = ArrayList<String>()
    private lateinit var arrayAdapter: ArrayAdapter<String>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = InsuranceFragmentBinding.bind(view)

        viewModel.getInsuranceCompanies()
        arrayAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            insuranceMenu
        )

        binding.root.setOnClickListener {
            hideKeyboard()
        }


        viewModel.insuranceResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    it.value.forEach {
                        insuranceMenu.add(it.name_en)
                        arrayAdapter.notifyDataSetChanged()
                    }
                }
                is Resource.Failure -> handleApiError(it) { }
            }
            binding.insuranceCompanySpinner.apply {
                adapter = arrayAdapter
                onItemSelectedListener = this@InsuranceFragment
            }
        });

        viewModel.addInsuranceResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    navigateSafe(InsuranceFragmentDirections.insuracneToHome())
                }
                is Resource.Failure -> handleApiError(it) {}
            }
        })



        binding.confirmButton.setOnClickListener {
            onConfirmClicked()
        }

        binding.skipButton.setOnClickListener {
            navigateSafe(InsuranceFragmentDirections.insuracneToHome())
        }

    }

    private fun onConfirmClicked() {
        val userInfo = UserSingleton.getCurrentUser()
//        userInfo.insuranceNumber = binding.insuranceNumberEditText.text.toString()
//        userInfo.insuranceCompany = itemSelected

        navigateSafe(InsuranceFragmentDirections.insuracneToHome())
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        itemSelected = insuranceMenu.get(p2)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

}