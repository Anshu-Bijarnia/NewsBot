package com.example.newsbot.api

import com.example.newsbot.models.NewsResponse
import com.example.newsbot.util.constants.Companion.API_KEY
import com.example.newsbot.util.constants.Companion.CATEGORY_SEARCHED
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    // This is for the breaking news
    @GET ("v2/top-headlines")
    suspend fun getBreakingNews (
        @Query("country")
        countryCode : String = "in",
        @Query("page")
        pageNumber : Int = 1,
        @Query ("apiKey")
        apiKey : String = API_KEY
    ) : Response <NewsResponse>

    // This is for the searching news
    @GET ("v2/everything")
    suspend fun searchForNews (
        @Query("q")
        searchQuery: String ,
        @Query("page")
        pageNumber : Int = 1,
        @Query ("apiKey")
        apiKey : String = API_KEY
    ) : Response <NewsResponse>

    // This is for the recent news
    @GET ("v2/everything")
    suspend fun getRecentNews (
        @Query("language")
        languageCode : String = "en",
        @Query("sortBy")
        sortBY: String = "publishedAt",
        @Query("page")
        pageNumber : Int = 1,
        @Query ("apiKey")
        apiKey : String = API_KEY
    ) : Response <NewsResponse>

    // This is for category news
    @GET ("v2/top-headlines")
    suspend fun categoryNews (
        @Query("category")
        category : String = CATEGORY_SEARCHED,
        @Query("page")
        pageNumber : Int = 1,
        @Query ("apiKey")
        apiKey : String = API_KEY
    ) : Response <NewsResponse>
}