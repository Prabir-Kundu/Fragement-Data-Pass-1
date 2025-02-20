package com.prabirkundu.fragementdatapass.RecyclerView_with_DiffUtil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.prabirkundu.fragementdatapass.R

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private var items = listOf<ItemNameModel>()

    // ViewHolder class
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNumber: TextView = itemView.findViewById(R.id.txtNumber)
        val txtDescription: TextView = itemView.findViewById(R.id.txtDescription)
    }

    // Create a DiffUtil.Callback
    class ItemDiffCallback(
        private val oldList: List<ItemNameModel>,
        private val newList: List<ItemNameModel>
    ) : DiffUtil.Callback() {
        override fun getOldListSize() = oldList.size
        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }

    // Create the DiffUtil method to update the list
    fun updateList(newItems: List<ItemNameModel>) {
        val diffCallback = ItemDiffCallback(items, newItems)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        items = newItems
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.main_item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.txtNumber.text = item.id.toString()
        holder.txtDescription.text = item.name
    }

    override fun getItemCount(): Int = items.size
}