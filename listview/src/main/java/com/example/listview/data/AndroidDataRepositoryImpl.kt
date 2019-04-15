package com.example.listview.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AndroidDataRepositoryImpl(private val jsonList: String) : AndroidDataRepository {

    override suspend fun getData(): LiveData<Array<AndroidDataModel>> {

        return withContext(Dispatchers.Main) {
            return@withContext MutableLiveData<Array<AndroidDataModel>>().apply {
                value = Gson().fromJson(jsonList, object : TypeToken<Array<AndroidDataModel>>() {}.type)
            }
        }
    }
}