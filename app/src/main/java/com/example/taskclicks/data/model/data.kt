package com.example.taskclicks.data.model

import com.google.gson.annotations.SerializedName

data class data(
    @SerializedName("status")
    val status:String,
    @SerializedName("totalResults")
    val totalResults:String,
    @SerializedName("articles")
    val articles: List<NewsData>
)