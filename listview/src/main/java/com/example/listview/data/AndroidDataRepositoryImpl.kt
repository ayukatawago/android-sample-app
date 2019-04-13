package com.example.listview.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AndroidDataRepositoryImpl(private val jsonList: String) : AndroidDataRepository {
    override fun getData(): Array<AndroidDataModel> {
        val gson = Gson()
        return gson.fromJson(jsonList, object : TypeToken<Array<AndroidDataModel>>() {}.type)
    }
}