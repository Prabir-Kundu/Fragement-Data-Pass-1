package com.prabirkundu.fragementdatapass

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prabirkundu.fragementdatapass.databinding.ActivityDashboardBinding
import com.prabirkundu.multipleconceptsinoneproject.model.Item

class DashboardActivity : AppCompatActivity() {
    lateinit var binding: ActivityDashboardBinding
    private val items = mutableListOf(
        Item(1, "Fragment Data Pass"),
        Item(2, "Implement a RecyclerView with DiffUtil and allow items to be dynamically updated."),
        Item(3, "Item 3")
    )
    lateinit var adapter: MainItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = findViewById<RecyclerView>(R.id.rvItem)
        adapter = MainItemAdapter(DashboardActivity@this,items )
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}