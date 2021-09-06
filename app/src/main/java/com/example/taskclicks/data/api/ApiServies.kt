package com.example.taskclicks.data.api

import androidx.lifecycle.MutableLiveData
import com.example.taskclicks.data.model.NewsData
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

const val api_key = "63b1f94dad044add871d1e319c630265"

interface ApiServies {

    @GET("top-headlines")
     suspend fun getNews(@Query("country") country : String ,
                        @Query("apiKey") apiKey : String)  : MutableLiveData<List<NewsData>>

}
