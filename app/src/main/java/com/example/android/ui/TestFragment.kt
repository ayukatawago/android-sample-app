package com.example.android.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
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
        val adapter = ArrayAdapter<String>(context!!, android.R.layout.simple_list_item_1, viewModel.items)
        val view = inflater.inflate(R.layout.test_fragment, container, false)
        view?.run {
            val listView = findViewById<ListView>(R.id.adapter)
            listView.adapter = adapter

            val btnAdd = findViewById<Button>(R.id.btn_add)
            btnAdd.setOnClickListener {
                viewModel.addNewItem()
                adapter.notifyDataSetChanged()
            }
        }
        return view
    }
}
