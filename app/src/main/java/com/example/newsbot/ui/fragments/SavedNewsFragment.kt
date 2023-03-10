package com.example.newsbot.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsbot.R
import com.example.newsbot.ui.NewsActivity
import com.example.newsbot.ui.NewsViewModel

class SavedNewsFragment : Fragment(R.layout.fragment_saved_news) {
    lateinit var viewModel : NewsViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }
}