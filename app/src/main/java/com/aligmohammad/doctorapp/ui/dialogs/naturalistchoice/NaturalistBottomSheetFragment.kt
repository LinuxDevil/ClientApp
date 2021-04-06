package com.aligmohammad.doctorapp.ui.dialogs.naturalistchoice

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.dto.AppointmentDTO
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.UserSingleton
import com.aligmohammad.doctorapp.databinding.NaturalistBottomSheetFragmentBinding
import com.aligmohammad.doctorapp.ui.adapters.DateRecyclerAdapter
import com.aligmohammad.doctorapp.ui.adapters.TimeRecyclerAdapter
import com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract
import com.aligmohammad.doctorapp.util.ProgressDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NaturalistBottomSheetFragment : BottomSheetDialogFragment(), OnDialogInteract {

    private lateinit var dateAdapter: DateRecyclerAdapter
    private lateinit var timeAdapter: TimeRecyclerAdapter

    private val viewModel by viewModels<NaturalistBottomSheetViewModel>()
    private lateinit var binding: NaturalistBottomSheetFragmentBinding

    private lateinit var dateSelected: String
    private lateinit var timeSelected: String

    private var shiftSelected: String? = "Morning"
    private var arrayOfDates = listOf<String>()
    private var arrayOfTimes = listOf<String>()
    private var testSelectedd = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.naturalist_bottom_sheet_fragment,
            container,
            false
        )
        binding.listener = this

        var dialog = ProgressDialog.progressDialog(requireContext())

        initializeRecycler()

        binding.dayTime.visibility = View.GONE
        binding.nightTime.visibility = View.GONE

        if (navArgs<NaturalistBottomSheetFragmentArgs>().value.doctorShifts != null) {
            navArgs<NaturalistBottomSheetFragmentArgs>().value.doctorShifts!!.forEach { shift ->
                if (shift == "Morning") {
                    binding.dayTime.visibility = View.VISIBLE
                }
                if (shift == "After noon") {
                    binding.nightTime.visibility = View.VISIBLE
                }
            }

            navArgs<NaturalistBottomSheetFragmentArgs>().value.let {
                arrayOfDates = it.dates!!.toList()
                arrayOfTimes = it.times!!.toList()
                initializeRecycler()
            }
        }

        viewModel.addAppointmentResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    if (it.value.appointmentEntity.hospital != null) {
                        Toast.makeText(
                            requireContext(),
                            "Success ${it.value.appointmentEntity.hospital.nameEn}",
                            Toast.LENGTH_LONG
                        ).show()
                        dialog.dismiss()
                    } else {
                        Toast.makeText(requireContext(), "Failed", Toast.LENGTH_LONG).show()
                    }
                }
                is Resource.Failure -> {
                    Log.v("TAG", it.errorResponse!!.string())
                    dialog.dismiss()
                }
                is Resource.Loading -> {
                    dialog.show()
                }
            }
        })

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

        return binding.root
    }

    override fun onBackButtonClicked(view: View) {
        this.dismiss()
    }

    override fun onButtonClicked(view: View) {
        addUserAppointment()
    }

    private fun addUserAppointment() {
        // Get the selections
        val appointment = AppointmentDTO(
            dateAdapter.getSelection().split(" ")[0],
            timeAdapter.getSelection(),
            navArgs<NaturalistBottomSheetFragmentArgs>().value.location + " - Naturalist",
            shiftSelected,
            UserSingleton.getCurrentUser().username,
            "",
            null,
            navArgs<NaturalistBottomSheetFragmentArgs>().value.hospitalId,
            "Operation",
            "Test A"
        )

        viewModel.addGeneralHospitalDoctorAppointment(appointment)

    }

    private fun initializeRecycler() {
        dateAdapter = DateRecyclerAdapter(arrayOfDates)
        binding.dateRecyclerView.apply {
            adapter = dateAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
        timeAdapter = TimeRecyclerAdapter(arrayOfTimes)
        binding.timeRecyclerView.apply {
            adapter = timeAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }


}