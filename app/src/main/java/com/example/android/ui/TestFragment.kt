package com.example.android.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.R

class TestFragment : Fragment() {

    companion object {
        fun newInstance() = TestFragment()
    }

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(TestViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val adapter = TestAdapter(viewModel.items)
        val view = inflater.inflate(R.layout.test_fragment, container, false)
        view?.run {
            val recyclerView = findViewById<RecyclerView>(R.id.adapter)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(context!!)

            val btnAdd = findViewById<Button>(R.id.btn_add)
            btnAdd.setOnClickListener {
                viewModel.addNewItem()
                adapter.notifyDataSetChanged()
            }
        }
        return view
    }
}
