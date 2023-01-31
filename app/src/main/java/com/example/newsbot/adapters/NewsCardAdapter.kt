package com.example.newsbot.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsbot.databinding.ItemArticleMainBinding
import com.example.newsbot.models.Article

class NewsCardAdapter : RecyclerView.Adapter<NewsCardAdapter.ArticleViewHolder>(){
    inner class ArticleViewHolder (val binding : ItemArticleMainBinding ) : RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    // This will compare the two list and compare them and calculate the difference
    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val layoutInflator = LayoutInflater.from(parent.context)
        val binding = ItemArticleMainBinding.inflate(layoutInflator,parent,false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.binding.apply {
            Glide.with(holder.itemView).load(article?.urlToImage).into(icon)
            headline.text = article?.title
            setOnItemClickListener {
                onItemClickListener?.let {
                    it(article)
                }
            }
        }
    }
    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener : ((Article) -> Unit)? = null
    fun setOnItemClickListener (listener : (Article) -> Unit) {
        onItemClickListener = listener
    }
}