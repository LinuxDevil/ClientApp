package com.aligmohammad.doctorapp.ui.fragments.appointment_list

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
import com.aligmohammad.doctorapp.data.model.firebasemodels.AppointmentFirebaseModel
import com.aligmohammad.doctorapp.databinding.AppointmentListFragmentBinding
import com.aligmohammad.doctorapp.ui.adapters.InProgressAppointmentRecyclerViewAdapter
import com.aligmohammad.doctorapp.util.snackbar
import com.aligmohammad.doctorappclient.ui.adapters.AppointmentRecyclerViewAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.appointment_list_fragment.view.toolbar
import kotlinx.android.synthetic.main.home_fragment.view.*

class AppointmentListFragment : Fragment() {

    private lateinit var viewModel: AppointmentListViewModel
    private lateinit var binding: AppointmentListFragmentBinding

    private var inProgressAppointments = arrayListOf<AppointmentFirebaseModel>()
    private var appointmentHistory = arrayListOf<AppointmentFirebaseModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.appointment_list_fragment, container, false)
        viewModel = ViewModelProvider(this).get(AppointmentListViewModel::class.java)
        initUI()
        getAllAppointments()
        initRecycler()

        binding.historyButton.setOnClickListener {
            binding.appointmentList.apply {
                adapter = AppointmentRecyclerViewAdapter(appointmentHistory, 0)
            }
        }

        binding.inProgressButton.setOnClickListener {
            binding.appointmentList.apply {
                adapter = InProgressAppointmentRecyclerViewAdapter(inProgressAppointments, 1)
            }
        }

        return binding.root
    }

    private fun initUI() {
        val appBarConfiguration =
            AppBarConfiguration(
                setOf(R.id.homeFragment, R.id.governmentHospitalsFragment),
                binding.root.drawerLayout
            )
        binding.root.toolbar.setupWithNavController(findNavController(), appBarConfiguration)
    }

    private fun initRecycler() {
        binding.appointmentList.apply {
            adapter = AppointmentRecyclerViewAdapter(inProgressAppointments)
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }


    private fun getAllAppointments() {
        val db = Firebase.database.reference
        db.child("Users").child("962776122035").child("Appointments")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    inProgressAppointments.clear()
                    appointmentHistory.clear()
                    snapshot.children.forEach { snap ->
                        db.child("Appointments").child(snap.value.toString()).addListenerForSingleValueEvent(object: ValueEventListener{
                            override fun onDataChange(snapshot: DataSnapshot) {
                                val appointment: AppointmentFirebaseModel =
                                    snapshot.getValue(AppointmentFirebaseModel::class.java)!!
                                if (appointment.inProgress) {
                                    inProgressAppointments.add(appointment)

                                } else {
                                    appointmentHistory.add(appointment)
                                }
                                initRecycler()
                            }

                            override fun onCancelled(error: DatabaseError) {
                            }

                        })

                        initRecycler()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    binding.appointmentList.snackbar(error.message)
                }
            })
    }


}