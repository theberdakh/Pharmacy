package com.theberdakh.pharmacy.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.theberdakh.pharmacy.data.util.convertJsonString
import com.theberdakh.pharmacy.data.util.jsonToString
import com.theberdakh.pharmacy.databinding.FragmentSearchBinding
import com.theberdakh.pharmacy.home.presentation.MedicineAdapter

class SearchFragment: Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = checkNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        initViews()


        return binding.root
    }

    private fun initViews() {
        val json = requireContext().jsonToString("dariler.json")
        val list = convertJsonString(json)
        val medicineAdapter = MedicineAdapter()

        if (list != null){
            val newList = list.toList()
            medicineAdapter.submitList(newList.subList(5, 11))
        }
        binding.recyclerSearch.adapter = medicineAdapter
    }
}