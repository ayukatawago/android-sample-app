package com.example.android.ui

import androidx.lifecycle.ViewModel

class TestViewModel : ViewModel() {
    val items = mutableListOf<String>()

    fun addNewItem() {
        items.add("Test Item ${items.size}")
    }
}
