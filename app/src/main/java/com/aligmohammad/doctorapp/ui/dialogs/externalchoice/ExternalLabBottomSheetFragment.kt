package com.aligmohammad.doctorapp.ui.dialogs.externalchoice

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.databinding.ExternalLabBottomSheetFragmentBinding
import com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract
import com.aligmohammad.doctorapp.ui.dialogs.operationschoice.OperationBottomSheetFragmentArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.external_lab_bottom_sheet_fragment.view.*
import navigateSafe
import java.util.*

@AndroidEntryPoint
class ExternalLabBottomSheetFragment : BottomSheetDialogFragment(), OnDialogInteract {

    private lateinit var doctorNames: ArrayList<String>
    private lateinit var arrayOfTimes: List<String>
    private lateinit var arrayOfDates: List<String>
    private val viewModel: ExternalLabBottomSheetViewModel by viewModels<ExternalLabBottomSheetViewModel>()
    private lateinit var binding: ExternalLabBottomSheetFragmentBinding

    private var selection: String = "External"
    private var type: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.external_lab_bottom_sheet_fragment,
            container,
            false
        )
        binding.listener = this

        if (navArgs<ExternalLabBottomSheetFragmentArgs>().value.doctor != null) {
            doctorNames =
                arrayListOf<String>(navArgs<ExternalLabBottomSheetFragmentArgs>().value.doctor?.name!!)
            binding.timeEditText.adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                doctorNames
            )
        }


        binding.timeEditText.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    arrayOfDates =
                        navArgs<OperationBottomSheetFragmentArgs>().value.doctor?.appointmentDates!!
                    arrayOfTimes =
                        navArgs<OperationBottomSheetFragmentArgs>().value.doctor?.appointmentTimes!!
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            }

        return binding.root
    }

    override fun onBackButtonClicked(view: View) {
        this.dismiss()
    }

    override fun onButtonClicked(view: View) {
        if (view.id == R.id.external || view.id == R.id.medical) {
            if (view.id == R.id.external) {
                type = "External"
            } else if (view.id == R.id.medical) {
                type = "Medical"
            }
            binding.root.optionsConstraint.visibility = View.VISIBLE
            binding.root.topLinear.visibility = View.GONE
        } else {
            val navController =
                Navigation.findNavController(requireActivity(), R.id.fragment)
            if (navController.currentDestination?.id == R.id.externalLabBottomSheetFragment2)
                this.navigateSafe(
                    ExternalLabBottomSheetFragmentDirections.externalToDate()
                        .setDates(arrayOfDates.toTypedArray()).setTimes(arrayOfTimes.toTypedArray())
                        .setDoctor(navArgs<OperationBottomSheetFragmentArgs>().value.doctor?.username)
                        .setLocation(navArgs<ExternalLabBottomSheetFragmentArgs>().value.location)
                        .setType(type)
                        .setDoctorShifts(arrayOf("Morning", "After noon"))
                )
            else {
                Log.v("MainActivity", navController.currentDestination?.label.toString())
            }
        }
    }


}