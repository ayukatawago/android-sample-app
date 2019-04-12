package com.example.listview.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.listview.data.AndroidDataModel
import kotlinx.android.synthetic.main.list_item_layout.view.*

class AndroidArrayAdapter(
    context: Context,
    private val resource: Int,
    objects: Array<AndroidDataModel>
) : ArrayAdapter<AndroidDataModel>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(parent.context)
                .inflate(resource, parent, false)
            holder = ViewHolder(
                view.tv_name,
                view.tv_version,
                view.tv_api
            )
            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val data = getItem(position) as AndroidDataModel
        holder.nameTextView.text = data.name
        holder.versionTextView.text = data.version
        holder.apiTextView.text = data.api

        return view
    }

    class ViewHolder(val nameTextView: TextView, val versionTextView: TextView, val apiTextView: TextView)
}