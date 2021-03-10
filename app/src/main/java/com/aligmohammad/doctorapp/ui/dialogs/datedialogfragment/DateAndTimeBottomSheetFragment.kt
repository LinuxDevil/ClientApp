package com.aligmohammad.doctorapp.ui.dialogs.datedialogfragment

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
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.nest.AddAppointment
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.UserSingleton
import com.aligmohammad.doctorapp.databinding.DateAndTimeBottomSheetFragmentBinding
import com.aligmohammad.doctorapp.ui.adapters.DateRecyclerAdapter
import com.aligmohammad.doctorapp.ui.adapters.TimeRecyclerAdapter
import com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract
import com.aligmohammad.doctorapp.ui.dialogs.externalchoice.ExternalLabBottomSheetViewModel
import com.aligmohammad.doctorapp.util.ProgressDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import navigateSafe

@AndroidEntryPoint
class DateAndTimeBottomSheetFragment : BottomSheetDialogFragment(), OnDialogInteract {

    private lateinit var dateAdapter: DateRecyclerAdapter
    private lateinit var timeAdapter: TimeRecyclerAdapter
    private lateinit var binding: DateAndTimeBottomSheetFragmentBinding

    private val viewModel: ExternalLabBottomSheetViewModel by viewModels<ExternalLabBottomSheetViewModel>()

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
            R.layout.date_and_time_bottom_sheet_fragment,
            container,
            false
        )
        binding.listener = this

        initializeRecycler()

        binding.dayTime.setOnClickListener {
            shiftSelected = "Morning"
            binding.nightTime.background = null
            binding.dayTime.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.active_drawable)
        }
        binding.nightTime.setOnClickListener {
            shiftSelected = "After noon"
            binding.dayTime.background = null
            binding.nightTime.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.active_drawable)
        }

        val dialog = ProgressDialog.progressDialog(requireContext())

        if (navArgs<DateAndTimeBottomSheetFragmentArgs>().value.doctorShifts != null) {
            navArgs<DateAndTimeBottomSheetFragmentArgs>().value.doctorShifts!!.forEach { shift ->
                if (shift == "Morning") {
                    binding.dayTime.visibility = View.VISIBLE
                }
                if (shift == "After noon") {
                    binding.nightTime.visibility = View.VISIBLE
                }
            }

            navArgs<DateAndTimeBottomSheetFragmentArgs>().value.let {
                arrayOfDates = it.dates!!.toList()
                arrayOfTimes = it.times!!.toList()
                initializeRecycler()
            }
        }

        viewModel.addAppointmentResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    dialog.dismiss()
                    if (it.value.doctor != null) {
                        val navController =
                            Navigation.findNavController(requireActivity(), R.id.fragment)
                        if (navController.currentDestination?.id == R.id.dateAndTimeBottomSheetFragment)
                            this.navigateSafe(DateAndTimeBottomSheetFragmentDirections.backToHome())
                        else {
                            Log.v(
                                "MainActivity",
                                navController.currentDestination?.label.toString()
                            )
                        }
                        Toast.makeText(requireContext(), "Success", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Failed, There was no time",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
                is Resource.Failure -> {
                    dialog.dismiss()
                    Log.v("TAG", it.errorResponse!!.string())
                }
                is Resource.Loading -> {
                    dialog.show()
                }
            }
        })

        binding.confirmButton.setOnClickListener {
            dateSelected = dateAdapter.getSelection()
            timeSelected = timeAdapter.getSelection()
            val appointment = AddAppointment(
                dateSelected,
                timeSelected,
                navArgs<DateAndTimeBottomSheetFragmentArgs>().value.location!! + " - " + navArgs<DateAndTimeBottomSheetFragmentArgs>().value.type,
                shiftSelected,
                UserSingleton.getCurrentUser().username,
                navArgs<DateAndTimeBottomSheetFragmentArgs>().value.doctor,
                null,
                null,
                navArgs<DateAndTimeBottomSheetFragmentArgs>().value.type
            )
            viewModel.addHospitalDoctorAppointment(appointment)

        }

        return binding.root
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


    override fun onBackButtonClicked(view: View) {
        this.dismiss()
    }


}