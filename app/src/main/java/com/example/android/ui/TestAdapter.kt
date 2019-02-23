package com.example.android.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.R

class TestAdapter(
    private val context: Context,
    private val items: List<String>
) : RecyclerView.Adapter<TestAdapter.TestViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        return TestViewHolder(LayoutInflater.from(context).inflate(R.layout.test_item, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.textView?.text = items[position]
    }

    class TestViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView? = view.findViewById(R.id.tv_item)
    }
}