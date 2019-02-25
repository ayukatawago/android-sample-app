package com.example.android.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.R
import com.example.android.model.TestItem

class TestFragment : Fragment() {

    companion object {
        fun newInstance() = TestFragment()
    }

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(TestViewModel::class.java)
    }

    private val adapter = TestAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.test_fragment, container, false)
        view?.run {
            val recyclerView = findViewById<RecyclerView>(R.id.adapter)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(context!!)

            val btnAdd = findViewById<Button>(R.id.btn_add)
            btnAdd.setOnClickListener {
                viewModel.addNewItem()
            }
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.items.observe(this, object : Observer<List<TestItem>> {
            override fun onChanged(items: List<TestItem>) {
                if (items.isNotEmpty())
                    adapter.items = items
            }
        })
    }
}
