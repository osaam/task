package com.example.taskclicks.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.example.taskclicks.R
import com.example.taskclicks.data.model.NewsData
import com.example.taskclicks.databinding.FragmentDetailesBinding


class DetailesFragment : Fragment() {
    private lateinit var binding: FragmentDetailesBinding
    private lateinit var homeViewModel: HomeViewModel
    var TAG = "DetailesFragment"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detailes, container, false)
        binding.lifecycleOwner = this
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding.homeviewModel = homeViewModel


        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var product: LiveData<NewsData> = homeViewModel.GetDataToDet()
        Log.d(TAG,"num of detaiels item "+product.value)}

}