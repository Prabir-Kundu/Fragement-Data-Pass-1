package com.prabirkundu.fragementdatapass.RecyclerView_with_DiffUtil

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.prabirkundu.fragementdatapass.R
import com.prabirkundu.fragementdatapass.databinding.ActivityRecyclerViewDiffUtilBinding

class RecyclerViewDiffUtilActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecyclerViewDiffUtilBinding
    lateinit var itemAdapter: ItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewDiffUtilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemAdapter = ItemAdapter()
        binding.rvItemView.layoutManager = LinearLayoutManager(this)
        binding.rvItemView.adapter = itemAdapter

        // Initial list
        val initialItems = listOf(
            ItemNameModel(1, "Item 1"),
            ItemNameModel(2, "Item 2"),
            ItemNameModel(3, "Item 3"),
            ItemNameModel(4, "Item 4"),
            ItemNameModel(5, "Item 5"),
            ItemNameModel(6, "Item 6"),
            ItemNameModel(7, "Item 7"),
            ItemNameModel(8, "Item 8"),
            ItemNameModel(9, "Item 9"),
            ItemNameModel(10, "Item 10"),
            ItemNameModel(11, "Item 11"),
            ItemNameModel(12, "Item 12"),
            ItemNameModel(14, "Item 14"),
            ItemNameModel(15, "Item 15"),
            ItemNameModel(16, "Item 16"),
            ItemNameModel(17, "Item 17"),
            ItemNameModel(18, "Item 18")
        )
        itemAdapter.updateList(initialItems)

        // Example of updating the list
        // Simulate dynamic data update
        val updatedItems = listOf(
            ItemNameModel(1, "Item 1 Updated"),
            ItemNameModel(3, "Item 3 Updated"),
            ItemNameModel(4, "Item 4 New")
        )

        // Simulate update after some time (e.g., button click or API call)
        Handler(Looper.getMainLooper()).postDelayed({
            itemAdapter.updateList(updatedItems)
        }, 2000)  // Update the list after 2 seconds
    }
}