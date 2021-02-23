



package com.aligmohammad.doctorapp.ui.fragments.medicineorder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.Medicine
import com.aligmohammad.doctorapp.databinding.MedicineOrderFragmentBinding
import com.aligmohammad.doctorapp.ui.adapters.MedicineListAdapter
import kotlinx.android.synthetic.main.medicine_order_fragment.view.*

class MedicineOrderFragment : Fragment() {

    private lateinit var viewModel: MedicineOrderViewModel
    private lateinit var binding: MedicineOrderFragmentBinding
    private var medicineItems = listOf<Medicine>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.medicine_order_fragment, container, false)
        viewModel = ViewModelProvider(this).get(MedicineOrderViewModel::class.java)
        binding.viewModel = viewModel

        val appBarConfiguration = AppBarConfiguration(findNavController().graph)
        binding.root.toolbar.setupWithNavController(findNavController(), appBarConfiguration)

        medicineItems = viewModel.getMedicine()

        initRecycler()

        return binding.root
    }

    private fun initRecycler() {
        val adapter = MedicineListAdapter(medicineItems)
        binding.root.medicineRecyclerView.apply {
            this.adapter = adapter
            this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

}