package com.aligmohammad.doctorapp.ui.fragments.armyplaces

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aligmohammad.doctorapp.R

class ArmyListFragment : Fragment() {

    companion object {
        fun newInstance() = ArmyListFragment()
    }

    private lateinit var viewModel: ArmyListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.army_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ArmyListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}