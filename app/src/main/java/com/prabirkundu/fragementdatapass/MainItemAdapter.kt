package com.prabirkundu.fragementdatapass

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prabirkundu.fragementdatapass.FregmantDataPass.MainActivity
import com.prabirkundu.multipleconceptsinoneproject.model.Item


class MainItemAdapter(
    private val context: Context,
    private val itemList: List<Item>
): RecyclerView.Adapter<MainItemAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.main_item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.txtNumber).text = itemList.get(position).id.toString()
            findViewById<TextView>(R.id.txtDescription).text = itemList.get(position).date
        }

        holder.itemView.setOnClickListener {
            if(position == 0){
                val intent = Intent(context,MainActivity::class.java)
                context.startActivity(intent)
            }
        }
    }
}