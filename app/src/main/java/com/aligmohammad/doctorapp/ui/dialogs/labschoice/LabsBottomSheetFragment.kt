



package com.aligmohammad.doctorapp.ui.dialogs.labschoice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.firebasemodels.AppointmentFirebaseModel
import com.aligmohammad.doctorapp.data.network.UserSingleton
import com.aligmohammad.doctorapp.databinding.LabsBottomSheetFragmentBinding
import com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract
import com.aligmohammad.doctorapp.util.hideKeyboard
import com.aligmohammad.doctorapp.util.snackbar
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog
import kotlinx.android.synthetic.main.labs_bottom_sheet_fragment.view.*
import java.util.*

class LabsBottomSheetFragment : BottomSheetDialogFragment(), OnDialogInteract,
    TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    private lateinit var viewModel: LabsBottomSheetViewModel
    private lateinit var binding: LabsBottomSheetFragmentBinding

    private var dateSelected = ""
    private var timeSelected = ""
    private var testSelectedd = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.labs_bottom_sheet_fragment, container, false)
        viewModel = ViewModelProvider(this).get(LabsBottomSheetViewModel::class.java)
        binding.listener = this
        binding.viewModel = viewModel

        binding.testSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val tests = resources.getStringArray(R.array.spinner)
                testSelectedd = tests[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        binding.root.dateEditText.setOnFocusChangeListener { view, b ->
            if (b) {
                val calendar = Calendar.getInstance()
                val datePicker = DatePickerDialog.newInstance(
                    this,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                )
                datePicker.show(fragmentManager!!, "DatePicker")
            }
        }
        binding.root.timeEditText.setOnFocusChangeListener { view, isFocused ->
            if (isFocused) {
                val calendar = Calendar.getInstance()
                val timePicker = TimePickerDialog.newInstance(
                    this,
                    calendar.get(Calendar.HOUR),
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND),
                    false
                )
                timePicker.show(fragmentManager!!, "TimePicker")
            }
        }

        binding.root.dateEditText.setOnClickListener {
            hideKeyboard()
            val calendar = Calendar.getInstance()
            val datePicker = DatePickerDialog.newInstance(
                this,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show(fragmentManager!!, "DatePicker")
        }

        binding.root.timeEditText.setOnClickListener {
            hideKeyboard()
            val calendar = Calendar.getInstance()
            val timePicker = TimePickerDialog.newInstance(
                this,
                calendar.get(Calendar.HOUR),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND),
                false
            )
            timePicker.show(fragmentManager!!, "TimePicker")
        }

        return binding.root
    }


    override fun onBackButtonClicked(view: View) {
        Toast.makeText(requireContext(), "Reserved!", Toast.LENGTH_LONG).show()
        this.dismiss()
    }

    override fun onButtonClicked(view: View) {
        addUserAppointment()
    }

    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        view!!.dismiss()
        binding.root.dateEditText.setText("${year}/${monthOfYear}/$dayOfMonth")
        dateSelected = "${year}/${monthOfYear+1}/$dayOfMonth"
    }

    override fun onTimeSet(view: TimePickerDialog?, hourOfDay: Int, minute: Int, second: Int) {
        var hourCalculation = hourOfDay
        var timing = "AM"
        if (hourCalculation >= 13) {
            hourCalculation -= 12
            timing = "PM"
        }
        timeSelected = "${hourCalculation}:${minute} ${timing}"
        binding.root.timeEditText.setText("${hourCalculation}:${minute} ${timing}")
    }

    private fun addUserAppointment() {
        // 1- Get user id
        val userId = UserSingleton.getCurrentUser().username
        // 2- Create appointment

        // 3- Push Appointment to db
        val database = Firebase.database.reference
        val appointmentUuid = database.push().key

        val appointment = AppointmentFirebaseModel(dateSelected, timeSelected, "Morning", userId, null, navArgs<LabsBottomSheetFragmentArgs>().value.placeUuid, testSelectedd, true, appointmentUuid)
        if (appointmentUuid != null) {
            hideKeyboard()
            database.child("Appointments").child(appointmentUuid).setValue(appointment).addOnCompleteListener {
                // 4- Add appointment id to user
                // 5- Push user changes
                database.child("Users").child(userId!!.substring(1, userId!!.length)).child("Appointments").child(appointmentUuid).setValue(appointmentUuid).addOnCompleteListener {
                    database.child("Places").child(navArgs<LabsBottomSheetFragmentArgs>().value.type!!).child(navArgs<LabsBottomSheetFragmentArgs>().value.placeUuid!!).child("Appointments").child(appointmentUuid).setValue(appointmentUuid)
                    dismiss()
                }.addOnFailureListener {
                    binding.dateEditText.snackbar(it.localizedMessage)
                    dismiss()
                }
            }.addOnFailureListener {
                binding.dateEditText.snackbar(it.localizedMessage)
                dismiss()
            }
        }

    }



}