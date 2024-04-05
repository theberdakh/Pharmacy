package com.theberdakh.pharmacy.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.theberdakh.pharmacy.R
import com.theberdakh.pharmacy.databinding.FragmentMainBinding
import com.theberdakh.pharmacy.home.HomeFragment
import com.theberdakh.pharmacy.utils.replaceFragment

class MainFragment: Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = checkNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        initViews()
        return binding.root
    }

    private fun initViews() {
        replaceFragment(childFragmentManager, R.id.nested_fragment_host, HomeFragment())
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}