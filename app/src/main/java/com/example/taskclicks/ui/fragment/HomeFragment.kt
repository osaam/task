package com.example.taskclicks.ui.fragment

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.taskclicks.R
import com.example.taskclicks.adapter.HomeAdapter
import com.example.taskclicks.data.model.NewsData
import com.example.taskclicks.databinding.FragmentHomeBinding
import com.example.taskclicks.helper.Helper


class HomeFragment : Fragment(), SearchView.OnQueryTextListener, HomeAdapter.HomeInterface {

    lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding
    lateinit var navController: NavController
    lateinit var homeAdapter: HomeAdapter
    lateinit var searchlist: MutableList<NewsData>
    var TAG = "HomeFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeNews()
        navController = Navigation.findNavController(view)
        binding.searchIcon.setOnClickListener {
                val searchText = binding.etSearch.text.toString()
                searchApi(searchText)
            }
    }

    private fun homeNews() {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeAdapter = HomeAdapter(arrayListOf(), this)
        binding.rvNews.adapter = homeAdapter
        homeViewModel.getItems.observe(viewLifecycleOwner, Observer {
            homeAdapter.addData(it)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search, menu)
        val search = menu.findItem(R.id.search_action)
        val searchView = search?.actionView as SearchView
        searchView.isSubmitButtonEnabled = true
        searchView.setOnQueryTextListener(this)

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            searchApi(query)
        }
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        if (query != null) {
            searchApi(query)
        }
        return true
    }

    private fun searchApi(query: String) {
        homeViewModel.SearchApi(query).observe(viewLifecycleOwner, Observer { data ->
            data?.let {
                homeAdapter.addData(listOf(it))
            } })}


    override fun OnItemClicked(item: NewsData) {
        homeViewModel.SetDataToDet(item)
        navController.navigate(R.id.home_to_details)
    }


}