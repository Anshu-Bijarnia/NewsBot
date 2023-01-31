package com.example.newsbot.repository

import com.example.newsbot.api.RetrofitInstance
import com.example.newsbot.db.ArticleDatabase

class NewsRepository (
    val db : ArticleDatabase
) {
    suspend fun getBreakingNews (countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)
}