package com.example.listview.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.listview.R
import kotlinx.android.synthetic.main.list_view_fragment.*

class ListViewFragment : Fragment() {

    companion object {
        fun newInstance() = ListViewFragment()
    }

    private val viewModel: ListViewViewModel by lazy {
        ViewModelProviders.of(this).get(ListViewViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_view_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listview?.apply {
            val data = viewModel.getData()
            val adapter = AndroidArrayAdapter(context, R.layout.list_item_layout, data)
            setAdapter(adapter)
        }
    }
}
