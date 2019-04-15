package com.example.listview.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.listview.R
import com.example.listview.data.AndroidDataRepositoryImpl
import kotlinx.android.synthetic.main.list_view_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

class ListViewFragment : Fragment() {

    companion object {
        fun newInstance() = ListViewFragment()
    }

    private val viewModel: ListViewViewModel by lazy {
        val jsonList = loadJSONFromAsset()
        ViewModelProviders.of(this, ListViewViewModelFactory(AndroidDataRepositoryImpl(jsonList)))
            .get(ListViewViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_view_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        GlobalScope.launch(Dispatchers.Main) {
            val data = viewModel.data.await()

            data.observe(this@ListViewFragment, Observer {
                if (it == null) return@Observer

                listview?.apply {
                    val adapter = AndroidArrayAdapter(context, R.layout.list_item_layout, it)
                    setAdapter(adapter)
                }
            })
        }
    }

    private fun loadJSONFromAsset(): String {
        context?.assets?.open("android.json")?.bufferedReader()?.use {
            return it.readText()
        }
        throw IOException()
    }
}
