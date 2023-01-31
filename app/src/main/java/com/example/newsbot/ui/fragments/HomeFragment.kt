package com.example.newsbot.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsbot.R
import com.example.newsbot.adapters.NewsCardAdapter
import com.example.newsbot.databinding.FragmentHomeBinding
import com.example.newsbot.ui.NewsActivity
import com.example.newsbot.ui.NewsViewModel
import com.example.newsbot.util.Resource

class HomeFragment : Fragment(R.layout.fragment_home) {
    lateinit var viewModel : NewsViewModel
    lateinit var newscardAdapter : NewsCardAdapter
    lateinit var binding: FragmentHomeBinding
    val TAG = "HomeFragment"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        viewModel = (activity as NewsActivity).viewModel

        setupRecyclerView()
        viewModel.breakingNews.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let { newsResponse ->
                        newscardAdapter.differ.submitList(newsResponse.articles)
                    }
                }
                is Resource.Error -> {
                    response.message?.let {message ->
                        Log.e(TAG,"An error occured: $message")
                    }
                }
                is Resource.Loading -> {

                }
            }
        })
    }

    private fun setupRecyclerView () {
        newscardAdapter = NewsCardAdapter()
        binding.apply {
            rvBreakingNews.apply {
                adapter = newscardAdapter
                layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
            }
            rvRecentNews.apply {
                adapter = newscardAdapter
                layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
            }
        }
    }
}