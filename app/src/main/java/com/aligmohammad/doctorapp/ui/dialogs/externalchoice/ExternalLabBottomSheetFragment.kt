package com.aligmohammad.doctorapp.ui.dialogs.externalchoice

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.databinding.ExternalLabBottomSheetFragmentBinding
import com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import navigateSafe

class ExternalLabBottomSheetFragment : BottomSheetDialogFragment(), OnDialogInteract {

    private lateinit var viewModel: ExternalLabBottomSheetViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ExternalLabBottomSheetFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.external_lab_bottom_sheet_fragment, container, false)
        viewModel = ViewModelProvider(this).get(ExternalLabBottomSheetViewModel::class.java)
        binding.listener = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onBackButtonClicked(view: View) {
        this.dismiss()
    }

    override fun onButtonClicked(view: View) {
        val navController = Navigation.findNavController(activity!!, R.id.fragment)
        if (navController.currentDestination?.id == R.id.externalLabBottomSheetFragment2)
            this.navigateSafe(ExternalLabBottomSheetFragmentDirections.externalToDate())
        else {
            Log.v("MainActivity", navController.currentDestination?.label.toString())
        }
    }


}