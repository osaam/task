package com.example.taskclicks.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


    object ApiClient   {
     //https://newsapi.org/v2/top-headlines?country=eg&apiKey=63b1f94dad044add871d1e319c630265
        private val Base_Url = "https://newsapi.org/v2/"
        val apiServies: ApiServies = getRetrofit()

        private fun getRetrofit(): ApiServies {
            return Retrofit.Builder().baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiServies::class.java)

        }
    }
