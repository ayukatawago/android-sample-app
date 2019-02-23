package com.example.android.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.databinding.TestItemBinding
import com.example.android.model.TestItem

class TestAdapter(
    private val items: List<TestItem>
) : RecyclerView.Adapter<TestAdapter.TestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        return TestViewHolder(TestItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.binding.item = items[position]
    }

    class TestViewHolder(val binding: TestItemBinding) : RecyclerView.ViewHolder(binding.root)
}