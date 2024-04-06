package com.theberdakh.pharmacy.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceFragmentCompat
import com.theberdakh.pharmacy.R
import com.theberdakh.pharmacy.databinding.FragmentAccountBinding

class AccountFragment: Fragment() {
    private var _binding: FragmentAccountBinding? = null
    private val binding get() = checkNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccountBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onDestroyView() {
        _binding= null
        super.onDestroyView()
    }
}