package com.example.android.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.model.TestItem

class TestViewModel : ViewModel() {
    private val _items = MutableLiveData<MutableList<TestItem>>()
    val items: LiveData<MutableList<TestItem>>
        get() = _items

    fun addNewItem() {
        val current = _items.value

        val new = if (current.isNullOrEmpty())
            listOf(TestItem("Test Item 0"))
        else
            current.plus(TestItem("Test Item ${current.size}"))
        _items.postValue(new as MutableList<TestItem>)
    }
}
