package com.jes.wikiworld

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jes.wikiworld.databinding.Itemlayout2Binding

class ItemAdapter2(private val items: MutableList<Item2>) : RecyclerView.Adapter<ItemAdapter2.ItemViewHolder>() {

    private val favoritos: MutableSet<Item2> = mutableSetOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = Itemlayout2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, favoritos.contains(item))

        holder.itemView.setOnClickListener {
            toggleSelection(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun getSelectedItems(): List<Item2> {
        return favoritos.toList()
    }
    fun clearSelection() {
        favoritos.clear()
        notifyDataSetChanged()
    }

    private fun toggleSelection(item: Item2) {
        if (favoritos.contains(item)) {
            favoritos.remove(item)
        } else {
            favoritos.add(item)
        }
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(val binding: Itemlayout2Binding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item2, isSelected: Boolean) {
            binding.nameTextView.text = item.nombre
            binding.descriptionTextView.text = item.description
            if (isSelected) {
                binding.root.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.selectedColor))
            } else {
                binding.root.setBackgroundColor(ContextCompat.getColor(binding.root.context, android.R.color.transparent))
            }
        }
    }
}