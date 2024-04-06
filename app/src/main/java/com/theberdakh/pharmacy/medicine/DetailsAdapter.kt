package com.theberdakh.pharmacy.medicine

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.theberdakh.pharmacy.databinding.ItemMedicineBinding
import com.theberdakh.pharmacy.databinding.ItemMedicineInfoBinding

class DetailsAdapter: ListAdapter<Detail, DetailsAdapter.DetailViewHolder>(DetailsDiffUtil()) {

    inner class DetailViewHolder(private val binding: ItemMedicineInfoBinding): ViewHolder(binding.root){
        fun bind(){
            val detail = getItem(adapterPosition)
            binding.detailTitle.text = detail.title
            binding.tvDetailContent.text = detail.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(
            ItemMedicineInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bind()
    }
}

data class Detail(
    val title: String,
    val content: String
)
class DetailsDiffUtil: DiffUtil.ItemCallback<Detail>(){
    override fun areItemsTheSame(oldItem: Detail, newItem: Detail): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Detail, newItem: Detail): Boolean {
       return oldItem.content == newItem.content
    }

}