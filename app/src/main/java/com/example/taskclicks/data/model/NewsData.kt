package com.example.taskclicks.data.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName


data class NewsData(
    @SerializedName("author")
    val author: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: Int,
    @SerializedName("source")
     val source:MutableList<source>
)

//@BindingAdapter("android:loadImage")
//fun ImageView.loadImage(image: Int) {
//    Glide.with(this)
//        .load(image)
//        .fitCenter()
//        .into(this)
//
//}
