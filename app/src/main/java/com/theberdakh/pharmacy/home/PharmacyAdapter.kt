package com.theberdakh.pharmacy.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.theberdakh.pharmacy.data.Pharmacy
import com.theberdakh.pharmacy.databinding.ItemPharmacyCompanyBinding



class PharmacyAdapter(val onClick: (Pharmacy) -> Unit): ListAdapter<Pharmacy, PharmacyAdapter.PharmacyViewHolder>(PharmacyDiffUtil()) {



    inner class PharmacyViewHolder(private val binding: ItemPharmacyCompanyBinding): ViewHolder(binding.root){
        fun bind(pharmacy: Pharmacy){
            binding.title.text = pharmacy.name
            binding.subtitle.text = pharmacy.subtitle
            binding.image.setImageResource(pharmacy.pic)
            binding.root.setOnClickListener {
                onClick.invoke(pharmacy)
            }
        }
    }


    override fun onBindViewHolder(holder: PharmacyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PharmacyViewHolder {
        return PharmacyViewHolder(ItemPharmacyCompanyBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }


}

class PharmacyDiffUtil: DiffUtil.ItemCallback<Pharmacy>(){
    override fun areItemsTheSame(oldItem: Pharmacy, newItem: Pharmacy): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: Pharmacy, newItem: Pharmacy): Boolean {
        return oldItem.id == newItem.id
    }

}