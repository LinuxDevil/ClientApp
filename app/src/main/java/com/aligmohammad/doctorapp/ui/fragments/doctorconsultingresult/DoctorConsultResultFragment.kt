





package com.aligmohammad.doctorapp.ui.fragments.doctorconsultingresult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.Medicine
import com.aligmohammad.doctorapp.databinding.DoctorConsultResultFragmentBinding
import com.aligmohammad.doctorapp.ui.adapters.MedicineListAdapter
import kotlinx.android.synthetic.main.doctor_consult_result_fragment.view.*
import navigateSafe

class DoctorConsultResultFragment : Fragment() {

    private lateinit var viewModel: DoctorConsultResultFragmentViewModel
    private lateinit var binding: DoctorConsultResultFragmentBinding

    private var medicineItems = listOf<Medicine>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.doctor_consult_result_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(DoctorConsultResultFragmentViewModel::class.java)
        binding.viewModel = viewModel

        val appBarConfiguration = AppBarConfiguration(findNavController().graph)
        binding.root.toolbar.setupWithNavController(findNavController(), appBarConfiguration)

        medicineItems = viewModel.getMedicine()

        binding.root.orderButton.setOnClickListener {
            val navController = Navigation.findNavController(activity!!, R.id.fragment)
            if (navController.currentDestination?.id == R.id.doctorConsultResultFragment) {
                this.navigateSafe(DoctorConsultResultFragmentDirections.medicineToOrder())
            }
        }

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