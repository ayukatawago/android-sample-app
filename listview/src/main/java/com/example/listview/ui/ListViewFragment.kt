package com.example.listview.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.listview.R
import kotlinx.android.synthetic.main.list_view_fragment.*

class ListViewFragment : Fragment() {

    companion object {
        fun newInstance() = ListViewFragment()
    }

    private lateinit var viewModel: ListViewViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_view_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listview?.apply {
            val names = arrayOf("Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread")
            val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, names)
            setAdapter(adapter)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListViewViewModel::class.java)
        // TODO: Use the ViewModel
    }
}
