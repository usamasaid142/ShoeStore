package com.udacity.shoestore.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.databinding.ShoeItemLayoutBinding
import com.udacity.shoestore.models.Shoe

class ShoeAdapter:ListAdapter<Shoe,ShoeAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view=ShoeItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shoes=getItem(position)

        holder.binding.apply {
            shoename.text=shoes.name
            size.text=shoes.size.toString()
            company.text=shoes.company
            description.text=shoes.description

        }

    }


    class ViewHolder(itemBinding: ShoeItemLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        internal val binding: ShoeItemLayoutBinding = itemBinding
    }


    private class DiffCallback : DiffUtil.ItemCallback<Shoe>() {
        override fun areItemsTheSame(oldItem: Shoe, newItem: Shoe): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: Shoe, newItem: Shoe): Boolean {
            return true
        }
    }


}