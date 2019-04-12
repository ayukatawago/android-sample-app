package com.example.listview.ui

import androidx.lifecycle.ViewModel
import com.example.listview.data.AndroidDataModel

class ListViewViewModel : ViewModel() {
    fun getData(): Array<AndroidDataModel> {
        return arrayOf(
            AndroidDataModel("Cupcake", "1.5", "3"),
            AndroidDataModel("Donut", "1.6", "4"),
            AndroidDataModel("Eclair", "2.0-2.1", "5-7"),
            AndroidDataModel("Froyo", "2.2-2.2.3", "8"),
            AndroidDataModel("Gingerbread", "2.3-2.3.7", "9-10"),
            AndroidDataModel("Honeycomb", "3.0-3.2.6", "11-13"),
            AndroidDataModel("Ice Cream Sandwich", "4.0-4.0.4", "14-15"),
            AndroidDataModel("Jelly Beans", "4.1-4.3.1", "16-18"),
            AndroidDataModel("KitKat", "4.4-4.4.4", "19-20"),
            AndroidDataModel("Lollipop", "5.0-5.1.1", "21-22"),
            AndroidDataModel("Marshmallow", "6.0-6.0.1", "23"),
            AndroidDataModel("Nougat", "7.0-7.1.1", "24-25"),
            AndroidDataModel("Oreo", "8.0-8.1", "26-27"),
            AndroidDataModel("Pie", "9.0", "28")
        )
    }
}
