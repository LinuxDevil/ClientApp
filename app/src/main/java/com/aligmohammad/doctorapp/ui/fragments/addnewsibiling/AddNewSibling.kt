package com.aligmohammad.doctorapp.ui.fragments.addnewsibiling

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.databinding.FragmentAddNewSibilingBinding
import com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class AddNewSibling : BottomSheetDialogFragment(), OnDialogInteract {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentAddNewSibilingBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add_new_sibiling,
            container,
            false
        )
        binding.listener = this
        return binding.root
    }

    override fun onBackButtonClicked(view: View) {
        this.dismiss()
    }


}