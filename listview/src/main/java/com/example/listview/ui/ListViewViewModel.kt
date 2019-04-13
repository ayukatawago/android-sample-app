package com.example.listview.ui

import androidx.lifecycle.ViewModel
import com.example.listview.data.AndroidDataModel
import com.example.listview.data.AndroidDataRepository

class ListViewViewModel(private val repository: AndroidDataRepository) : ViewModel() {
    val data: Array<AndroidDataModel>
        get() = repository.getData()
}
