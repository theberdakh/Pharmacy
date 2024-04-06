package com.theberdakh.pharmacy.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.theberdakh.pharmacy.R
import com.theberdakh.pharmacy.data.MedicineRepository.getAllPharmacies
import com.theberdakh.pharmacy.data.util.convertJsonString
import com.theberdakh.pharmacy.data.util.jsonToString
import com.theberdakh.pharmacy.databinding.FragmentHomeBinding
import com.theberdakh.pharmacy.home.presentation.MedicineAdapter
import com.theberdakh.pharmacy.home.presentation.PharmacyAdapter
import com.theberdakh.pharmacy.medicine.MedicineFragment
import com.theberdakh.pharmacy.utils.addFragment
import com.theberdakh.pharmacy.utils.addFragmentToBackStack

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
        val medicineAdapter = MedicineAdapter{
            addFragmentToBackStack(
                requireActivity().supportFragmentManager,
                R.id.parent_fragment_host,
                MedicineFragment(it)
            )
        }

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