package com.theberdakh.pharmacy.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.Orientation
import com.theberdakh.pharmacy.data.Medicine
import com.theberdakh.pharmacy.data.convertJsonString
import com.theberdakh.pharmacy.data.getAllPharmacies
import com.theberdakh.pharmacy.data.jsonToString
import com.theberdakh.pharmacy.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = checkNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        initViews()

        //pharmacy companies as list "near to me"
            //some medicines 10

        return binding.root
    }

    private fun initViews() {
        initPharmacies()
    }

    private fun initPharmacies() {
        val pharmacyAdapter = PharmacyAdapter{
            println("clicked")
        }
        pharmacyAdapter.submitList(getAllPharmacies())


        val json = requireContext().jsonToString("dariler.json")
        val list = convertJsonString(json)
        val medicineAdapter = MedicineAdapter()

        if (list != null){
            val newList = list.toList()
            medicineAdapter.submitList(newList)
        }

        binding.recyclerViewPharmacy.adapter = pharmacyAdapter
        binding.recyclerViewMedicine.adapter = medicineAdapter



    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}