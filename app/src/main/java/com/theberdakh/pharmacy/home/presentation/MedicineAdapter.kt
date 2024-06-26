package com.theberdakh.pharmacy.home.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.theberdakh.pharmacy.data.Medicine
import com.theberdakh.pharmacy.databinding.ItemMedicineBinding

class MedicineAdapter(private val onClick: (Medicine) -> Unit) :
    ListAdapter<Medicine, MedicineAdapter.MedicineViewHolder>(MedicineDiffUtil()) {

    inner class MedicineViewHolder(val binding: ItemMedicineBinding) : ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onClick.invoke(getItem(adapterPosition))
            }
        }

        fun bind() {
            val medicine = getItem(adapterPosition)
            binding.title.text = medicine.name
            binding.subtitle.text = medicine.characteristics

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineViewHolder {
        return MedicineViewHolder(
            ItemMedicineBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MedicineViewHolder, position: Int) {
        holder.bind()
    }

}

class MedicineDiffUtil : DiffUtil.ItemCallback<Medicine>() {
    override fun areItemsTheSame(oldItem: Medicine, newItem: Medicine): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Medicine, newItem: Medicine): Boolean {
        return oldItem == newItem
    }

}