package com.aligmohammad.doctorapp.ui.fragments.doctormajor

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.RecyclerMenuItem
import com.aligmohammad.doctorapp.data.model.firebasemodels.MajorsFirebaseModel
import com.aligmohammad.doctorapp.databinding.DoctorMajorFragmentItemListBinding
import com.aligmohammad.doctorapp.ui.adapters.MyDoctorMajorRecyclerViewAdapter
import com.aligmohammad.doctorapp.ui.adapters.OnMenuItemClick
import com.aligmohammad.doctorapp.ui.fragments.homefragment.HomeFragmentDirections
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.doctor_major_fragment_item_list.view.*

class DoctorMajorFragment : Fragment(), OnMenuItemClick {

    private val arrayList = arrayListOf<RecyclerMenuItem>()
    private val arrayListOfMajors = arrayListOf<MajorsFirebaseModel>()

    private var columnCount = 3
    private lateinit var binding: DoctorMajorFragmentItemListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.doctor_major_fragment_item_list,
            container,
            false
        )

        getFirebaseData()

        val appBarConfiguration = AppBarConfiguration(findNavController().graph)
        binding.root.toolbar.setupWithNavController(findNavController(), appBarConfiguration)
        getData()
        initRecycler()
        return binding.root
    }

    private fun initRecycler() {
        with(binding.list) {
            layoutManager = LinearLayoutManager(context)
            adapter = MyDoctorMajorRecyclerViewAdapter(arrayListOfMajors, this@DoctorMajorFragment)
        }
    }

    private fun getFirebaseData() {
        val db = Firebase.database.reference
        db.child("Majors").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.children.forEach { snap ->
                    arrayListOfMajors.clear()
                    snap.getValue(MajorsFirebaseModel::class.java)?.let {
                        arrayListOfMajors.add(
                            it
                        )
                        initRecycler()
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

    private fun getData() {
        arrayList.clear()
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeToNewAppointment()
            )
        )
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeToNewAppointment()
            )
        )
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeToNewAppointment()
            )
        )
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeToNewAppointment()
            )
        )
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeToNewAppointment()
            )
        )
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeToNewAppointment()
            )
        )
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeToNewAppointment()
            )
        )
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeToNewAppointment()
            )
        )
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeToNewAppointment()
            )
        )
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeToNewAppointment()
            )
        )
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeToNewAppointment()
            )
        )
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeToNewAppointment()
            )
        )
    }

    override fun onClick(v: View) {
        // pass list here
    }

    override fun onClickMenu(v: View?, menuItem: MajorsFirebaseModel) {
        super.onClickMenu(v, menuItem)
        Navigation.findNavController(v!!).navigate(DoctorMajorFragmentDirections.majorToDoctorList("").setDoctorArray(menuItem.doctorList!!.toTypedArray()))
    }
}