package com.aligmohammad.doctorapp.ui.dialogs.operationschoice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.databinding.OpertaionBottomSheetFragmentBinding
import com.aligmohammad.doctorapp.ui.adapters.DateRecyclerAdapter
import com.aligmohammad.doctorapp.ui.adapters.TimeRecyclerAdapter
import com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class OperationBottomSheetFragment : BottomSheetDialogFragment(), OnDialogInteract {

    private lateinit var binding: OpertaionBottomSheetFragmentBinding
    private val viewModel: OpertaionBottomSheetViewModel by viewModels<OpertaionBottomSheetViewModel>()

    private var arrayOfDates = listOf<String>()
    private var arrayOfTimes = listOf<String>()
    private var doctorNames = listOf<String>()

    private var shiftSelected: String = ""
    private var timeSelected: String = ""
    private var dateSelected: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.opertaion_bottom_sheet_fragment,
            container,
            false
        )
        binding.listener = this

        initializeRecycler()

        binding.dayTime.visibility = View.GONE
        binding.nightTime.visibility = View.GONE

        if (navArgs<OperationBottomSheetFragmentArgs>().value.doctorShifts != null) {
            navArgs<OperationBottomSheetFragmentArgs>().value.doctorShifts!!.forEach { shift ->
                if (shift == "Morning") {
                    binding.dayTime.visibility = View.VISIBLE
                }
                if (shift == "After noon") {
                    binding.nightTime.visibility = View.VISIBLE
                }
            }

            navArgs<OperationBottomSheetFragmentArgs>().value.let {
                arrayOfDates = it.dates!!.toList()
                arrayOfTimes = it.times!!.toList()
                initializeRecycler()
            }
        }

        if (navArgs<OperationBottomSheetFragmentArgs>().value.doctor != null) {
            doctorNames =
                arrayListOf<String>(navArgs<OperationBottomSheetFragmentArgs>().value.doctor?.name!!)
            binding.doctorsSpinner.adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                doctorNames
            )
        }

        binding.dayTime.setOnClickListener {
            binding.nightTime.background = null
            binding.dayTime.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.active_drawable)
            shiftSelected = "Morning"
        }

        binding.nightTime.setOnClickListener {
            binding.dayTime.background = null
            binding.nightTime.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.active_drawable)
            shiftSelected = "After Noon"
        }

        binding.confirmButton.setOnClickListener {
//            addUserAppointment()
        }

        return binding.root
    }

    private fun initializeRecycler() {
        binding.dateRecyclerView.apply {
            adapter = DateRecyclerAdapter(arrayOfDates)
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        binding.timeRecyclerView.apply {
            adapter = TimeRecyclerAdapter(arrayOfTimes)
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }


    override fun onBackButtonClicked(view: View) {
        Toast.makeText(requireContext(), "Reserved!", Toast.LENGTH_LONG).show()
        this.dismiss()
    }

    override fun onButtonClicked(view: View) {
        this.dismiss()
    }

}