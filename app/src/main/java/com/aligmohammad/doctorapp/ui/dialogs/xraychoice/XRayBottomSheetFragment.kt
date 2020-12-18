/*******************************************************************************
 *
 * Copyright RectiCode(c) 2020.
 * All Rights Reserved
 *
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and de-compilation.
 *
 * Created by Ali Mohammad
 *
 ******************************************************************************/

/*******************************************************************************
 *
 * Copyright RectiCode(c) 2020.
 * All Rights Reserved
 *
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and de-compilation.
 *
 * Created by Ali Mohammad
 *
 ******************************************************************************/

package com.aligmohammad.doctorapp.ui.dialogs.xraychoice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.databinding.XRayBottomSheetFragmentBinding
import com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog
import kotlinx.android.synthetic.main.x_ray_bottom_sheet_fragment.view.*
import java.util.*

class XRayBottomSheetFragment : BottomSheetDialogFragment(), OnDialogInteract,
    TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    private lateinit var binding: XRayBottomSheetFragmentBinding
    private lateinit var viewModel: XRayBottomSheetViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.x_ray_bottom_sheet_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(XRayBottomSheetViewModel::class.java)
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