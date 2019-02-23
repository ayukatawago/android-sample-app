package com.example.android.ui

import androidx.lifecycle.ViewModel
import com.example.android.model.TestItem

class TestViewModel : ViewModel() {
    val items = mutableListOf<TestItem>()

    fun addNewItem() {
        items.add(TestItem("Test Item ${items.size}"))
    }
}
