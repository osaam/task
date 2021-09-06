package com.example.taskclicks.ui.fragment

import android.content.ContentValues
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.taskclicks.R
import com.example.taskclicks.data.api.ApiClient
import com.example.taskclicks.data.api.api_key
import com.example.taskclicks.data.model.NewsData
import com.example.taskclicks.data.model.dataset
import kotlinx.coroutines.*
import java.lang.Exception
import java.util.ArrayList

class HomeViewModel : ViewModel() {
    val apiServies = ApiClient.apiServies
    val Tag = "HomeViewModel"

    val searchlist: MutableLiveData<NewsData> = MutableLiveData()

    var dataDetails: MutableLiveData<NewsData> = MutableLiveData()
    var mutableList = MutableLiveData<List<NewsData>>()
    val getItems: MutableLiveData<List<NewsData>>
        get() {
            loadItems()
            return mutableList
        }

    private fun loadItems() {

        GlobalScope.launch {
            try {
                mutableList= apiServies.getNews("eg", "63b1f94dad044add871d1e319c630265")
                Log.d(Tag, "getdata11: ${mutableList.value}")
            } catch (e: Exception) {
                Log.d(ContentValues.TAG, "getdata10: ${e.message}")
            }
        }
    }

    fun SearchApi(query: String): MutableLiveData<NewsData> {
        mutableList.value?.forEach {
            if (it.title.contains(query)) {
                searchlist.value = it
            }
        }
        return searchlist
    }

    fun SetDataToDet(item: NewsData) {
        dataDetails.value = item
        dataset.details = item
    }

    fun GetDataToDet(): LiveData<NewsData> {
        dataDetails.value = dataset.details
        return dataDetails
    }
}