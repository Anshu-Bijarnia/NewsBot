package com.example.newsbot.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "articles"
)
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null, // nullable integer because not every entry will be saved in the room database
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)