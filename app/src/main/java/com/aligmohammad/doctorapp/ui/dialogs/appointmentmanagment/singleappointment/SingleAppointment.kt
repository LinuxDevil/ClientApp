package com.aligmohammad.doctorapp.ui.dialogs.appointmentmanagment.singleappointment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.network.UserSingleton
import com.aligmohammad.doctorapp.databinding.SingleAppointmentFragmentBinding
import com.aligmohammad.doctorapp.ui.adapters.DateRecyclerAdapter
import com.aligmohammad.doctorapp.ui.adapters.TimeRecyclerAdapter
import com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract
import com.aligmohammad.doctorapp.util.snackbar
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SingleAppointment : BottomSheetDialogFragment(), OnDialogInteract {

    private lateinit var viewModel: SingleAppointmentViewModel
    private lateinit var binding: SingleAppointmentFragmentBinding

    private var arrayOfDates = listOf<String>()
    private var arrayOfTimes = listOf<String>()

    private var shiftSelected: String = ""
    private var timeSelected: String = ""
    private var dateSelected: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.single_appointment_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(SingleAppointmentViewModel::class.java)
        binding.viewModel = viewModel
        binding.listener = this
        initializeRecycler()

        binding.dayTime.visibility = View.GONE
        binding.nightTime.visibility = View.GONE

        navArgs<SingleAppointmentArgs>().value.doctorShifts!!.forEach { shift ->
            if (shift == "Morning") {
                binding.dayTime.visibility = View.VISIBLE
            }
            if (shift == "After noon") {
                binding.nightTime.visibility = View.VISIBLE
            }
        }

        navArgs<SingleAppointmentArgs>().value.let {
            arrayOfDates = it.dates!!.toList()
            arrayOfTimes = it.times!!.toList()
            initializeRecycler()
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

        binding.reserveButton.setOnClickListener {
            addUserAppointment()
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

    private fun addUserAppointment() {
        // 1- Get user id
    }

    override fun onBackButtonClicked(view: View) {
        this.dismiss()
    }

}