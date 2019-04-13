package com.example.listview.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.listview.data.AndroidDataRepository

class ListViewViewModelFactory(private val repository: AndroidDataRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListViewViewModel(repository) as T
    }
}