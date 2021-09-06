package com.example.taskclicks.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskclicks.data.model.NewsData
import com.example.taskclicks.databinding.ItemNewsBinding

class HomeAdapter(val list: MutableList<NewsData>, val homeInterface: HomeInterface) :
    RecyclerView.Adapter<HomeAdapter.ViewHolderHome>() {
    val Tag = "HomeAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHome {
        return ViewHolderHome(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: ViewHolderHome, position: Int) {
        val item: NewsData = list[position]
        holder.binding.item = item

        holder.binding.card.setOnClickListener(View.OnClickListener {
            homeInterface.OnItemClicked(item)
        })

    }

    fun addData(listItem: List<NewsData>) {
        list.addAll(listItem)
        notifyDataSetChanged()
        Log.d(Tag, "num of list" + list.size)
    }

    override fun getItemCount(): Int = list.size

    class ViewHolderHome(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    interface HomeInterface {
        fun OnItemClicked(item: NewsData)


}}