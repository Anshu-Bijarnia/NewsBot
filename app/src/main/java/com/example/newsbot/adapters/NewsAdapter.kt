package com.example.newsbot.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsbot.api.NewsAPI
import com.example.newsbot.databinding.ItemArticleMainBinding

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>(){
    inner class ArticleViewHolder (val binding : ItemArticleMainBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}