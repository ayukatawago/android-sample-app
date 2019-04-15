package com.example.listview.data

import androidx.lifecycle.LiveData

interface AndroidDataRepository {
    suspend fun getData(): LiveData<Array<AndroidDataModel>>
}