package com.aligmohammad.doctorapp.ui.dialogs.citydistrictcompanydialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.databinding.CityDistrictCompanyFragmentBinding
import com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.city_district_company_fragment.view.*
import navigateSafe

class CityDistrictCompanyFragment : BottomSheetDialogFragment(), OnDialogInteract {

    private lateinit var viewModel: CityDistrictCompanyViewModel
    private lateinit var binding: CityDistrictCompanyFragmentBinding

    private lateinit var districts: Array<String>

    private var selectedDistrict = ""
    private var selectedCity = ""
    private var selectedInsurance = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.city_district_company_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(CityDistrictCompanyViewModel::class.java)
        binding.viewModel = viewModel
        binding.listener = this
        binding.root.confirm_button.setOnClickListener {
            onConfirmClicked(it)
        }

        /**
        1  <item>عمان</item>
        2   <item>اربد</item>
        3   <item>الزرقاء</item>
        4   <item>عجلون</item>
        5   <item>مأدبا</item>
        6   <item>المفرق</item>
        7   <item>العقبة</item>
        8   <item>جرش</item>
        9   <item>الكرك</item>
        10   <item>الطفيلة</item>
        11   <item>السلط</item>
        12   <item>معان</item>
         */

        binding.citiesSpinner.onItemSelectedListener =
            (object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val cities = resources.getStringArray(R.array.cities)
                    when (p2) {
                        0 -> {
                            districts = resources.getStringArray(R.array.amman_district)
                        }
                        1 -> {
                            districts = resources.getStringArray(R.array.irbid_districts)
                        }
                        2 -> {
                            districts = resources.getStringArray(R.array.zarka_districts)

                        }
                        3 -> {
                            districts = resources.getStringArray(R.array.ajloun_districts)

                        }
                        4 -> {
                            districts = resources.getStringArray(R.array.madaba_districts)

                        }
                        5 -> {
                            districts = resources.getStringArray(R.array.mafraq_districts)

                        }
                        6 -> {
                            districts = resources.getStringArray(R.array.aqaba_districts)

                        }
                        7 -> {
                            districts = resources.getStringArray(R.array.jarash_districts)

                        }
                        8 -> {
                            districts = resources.getStringArray(R.array.alkarak_districts)

                        }
                        9 -> {
                            districts = resources.getStringArray(R.array.tafeleh_districts)

                        }
                        10 -> {
                            districts = resources.getStringArray(R.array.alsalt_districts)

                        }
                        11 -> {
                            districts = resources.getStringArray(R.array.maan_districts)

                        }
                    }
                    binding.districtSpinner.adapter = ArrayAdapter(
                        requireContext(),
                        android.R.layout.simple_dropdown_item_1line,
                        districts
                    )
                    selectedCity = cities[p2]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            })

        binding.districtSpinner.onItemSelectedListener =
            (object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    selectedDistrict = districts[p2]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            })

        binding.insuranceCompanyTextViewSpinner.onItemSelectedListener =
            (object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val insurances = resources.getStringArray(R.array.spinner)
                    selectedInsurance = insurances[p2]

                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            })

        return binding.root
    }

    override fun onBackButtonClicked(view: View) {
        dismiss()
    }

    private fun onConfirmClicked(view: View) {
        val navController = Navigation.findNavController(requireActivity(), R.id.fragment)
        if (navArgs<CityDistrictCompanyFragmentArgs>().value.type != "consult") {
            if (navController.currentDestination?.id == R.id.cityDistrictCompanyFragment) {
                this.navigateSafe(
                    CityDistrictCompanyFragmentDirections.labsToList(selectedDistrict)
                        .setCity(selectedCity).setInsuranceName(selectedInsurance)
                        .setType(navArgs<CityDistrictCompanyFragmentArgs>().value.type)
                )
            }
        } else {
            if (navController.currentDestination?.id == R.id.cityDistrictCompanyFragment) {
                this.navigateSafe(
                    CityDistrictCompanyFragmentDirections.cityToSymptoms()
                        .setDistrict(selectedDistrict).setCity(selectedCity)
                        .setInsuranceName(selectedInsurance)
                )
            }
        }
    }

}