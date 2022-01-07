package com.example.retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=in&apiKey=API_KEY
//https://newsapi.org/v2/everything?q=tesla&from=2021-12-07&sortBy=publishedAt&apiKey=API_KEY

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "acbf05cb82074db292a102a8dcf3816b"

interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country: String,@Query("page") page: Int): Call<NewsDataClass>
    //fun getHeadlines(@Query("country") country: String,@Query("page") page: Int): Call<NewsDataClass>
}

object NewsService{
    val newsInstance: NewsInterface
    init {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}