package com.yassine.catsapp.repository

import com.yassine.catsapp.api.RetrofitInstance
import com.yassine.catsapp.model.CatImage
import com.yassine.catsapp.model.Category
import retrofit2.Response

class Repository {

    suspend fun getCategories(): Response<List<Category>> {
        return RetrofitInstance.service.getCategories()
    }

    suspend fun getRandomCat(): Response<List<CatImage>> {
        return RetrofitInstance.service.getRandomCat()
    }

    /*
    suspend fun getRandomCatByCategory(id: Int, options: Map<Int, String>): Response<List<CatImage>> {
        return RetrofitInstance.service.getRandomCatByCategory(id, options)
    }
    */
}