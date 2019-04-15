package com.example.listview.ui

import androidx.lifecycle.ViewModel
import com.example.listview.data.AndroidDataRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class ListViewViewModel(private val repository: AndroidDataRepository) : ViewModel() {
    val data by lazy {
        GlobalScope.async {
            repository.getData()
        }
    }
}
