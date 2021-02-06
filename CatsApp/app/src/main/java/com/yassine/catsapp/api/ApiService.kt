package com.yassine.catsapp.api

import com.yassine.catsapp.model.CatImage
import com.yassine.catsapp.model.Category
import retrofit2.http.GET
import retrofit2.Response

interface ApiService {

    @GET("/v1/categories?api_key=4810da08-bc44-4a77-864d-a68b6a249035")
    suspend fun getCategories(): Response<List<Category>>

    @GET("/v1/images/search?api_key=17d94b92-754f-46eb-99a0-65be65b5d18f&order=RANDOM&limit=1")
    suspend fun getRandomCat(): Response<List<CatImage>>
}