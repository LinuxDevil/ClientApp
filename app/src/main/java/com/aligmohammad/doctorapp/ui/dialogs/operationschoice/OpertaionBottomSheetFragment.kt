package com.aligmohammad.doctorapp.ui.dialogs.operationschoice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.databinding.OpertaionBottomSheetFragmentBinding
import com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog
import kotlinx.android.synthetic.main.opertaion_bottom_sheet_fragment.view.*
import java.util.*

class OpertaionBottomSheetFragment : BottomSheetDialogFragment(), OnDialogInteract,
    TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    private lateinit var binding: OpertaionBottomSheetFragmentBinding
    private lateinit var viewModel: OpertaionBottomSheetViewModel

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
        viewModel = ViewModelProvider(this).get(OpertaionBottomSheetViewModel::class.java)
        binding.viewModel = viewModel
        binding.listener = this
        binding.root.dateEditText.setOnFocusChangeListener { view, b ->
            if (b) {
                val calendar = Calendar.getInstance()
                val datePicker = DatePickerDialog.newInstance(
                    this,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                )
                datePicker.show(requireFragmentManager(), "DatePicker")
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
                timePicker.show(requireFragmentManager(), "TimePicker")
            }
        }
        return binding.root
    }

    override fun onBackButtonClicked(view: View) {
        Toast.makeText(requireContext(), "Reserved!", Toast.LENGTH_LONG).show()
        this.dismiss()
    }

    override fun onButtonClicked(view: View) {
        this.dismiss()
    }

    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        view!!.dismiss()
        binding.root.dateEditText.setText("${year}/${monthOfYear}/$dayOfMonth")
    }

    override fun onTimeSet(view: TimePickerDialog?, hourOfDay: Int, minute: Int, second: Int) {
        var hourCalculation = hourOfDay
        var timing = "AM"
        if (hourCalculation >= 13) {
            hourCalculation -= 12
            timing = "PM"
        }
        binding.root.timeEditText.setText("${hourCalculation}:${minute} ${timing}")
    }

}