package com.theberdakh.pharmacy.medicine

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.theberdakh.pharmacy.data.Medicine
import com.theberdakh.pharmacy.databinding.FragmentMedicineBinding

class MedicineFragment(private val medicine: Medicine) : Fragment() {
    private var _binding: FragmentMedicineBinding? = null
    private val binding get() = checkNotNull(_binding)

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMedicineBinding.inflate(inflater, container, false)


        val characteristics = Detail("Xarakteristikası", medicine.characteristics)
        val composition = Detail("Kompozitciyası", medicine.composition)
        val conditions = Detail("Jaǵdaylar", medicine.conditions)
        val definition = Detail("Túsindirmesi", medicine.definition)
        val disclaimer = Detail("Eskertpe", medicine.disclaimer)
        val mainElement = Detail("Tıykarǵı element", medicine.main_element)
        val pharmacokinetics = Detail("Farmokinetikası", medicine.pharmacokinetics)
        val sideEffects = Detail("Kútilmegen tásirleri", medicine.side_effects)
        val specialInstruction = Detail("Arnawlı Qollanba", medicine.special_instruction)
        val term = Detail("Múddeti", medicine.term)
        val usage = Detail("Paydalanıw", medicine.usage)

        val allDetails = listOf(
            characteristics,
            composition,
            conditions,
            definition,
            disclaimer,
            mainElement,
            pharmacokinetics,
            sideEffects,
            specialInstruction,
            term,
            usage
        )

        val chipGeneralItems = listOf(mainElement, definition, conditions, term)
        val chipCharacteristicsItems = listOf(composition, characteristics)
        val chipUsageItems = listOf(usage, pharmacokinetics)
        val chipWarningItems = listOf(disclaimer, sideEffects, specialInstruction)

        binding.titleMedicine.title = medicine.name
        binding.titleMedicine.setNavigationOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
        val adapter = DetailsAdapter()
        binding.rvMedicineDetails.adapter = adapter

        adapter.submitList(chipCharacteristicsItems)

        binding.chipGeneral.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                adapter.submitList(chipGeneralItems)
                adapter.notifyDataSetChanged()
            }
        }

        binding.chipCharacteristics.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                adapter.submitList(chipCharacteristicsItems)
                adapter.notifyDataSetChanged()
            }
        }

        binding.chipUsage.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                adapter.submitList(chipUsageItems)
                adapter.notifyDataSetChanged()
            }
        }

        binding.chipWarning.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                adapter.submitList(chipWarningItems)
                adapter.notifyDataSetChanged()
            }
        }


        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}