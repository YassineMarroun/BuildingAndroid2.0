package com.yassine.catsapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yassine.catsapp.model.CatImage
import com.yassine.catsapp.model.Category
import com.yassine.catsapp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponseCategory: MutableLiveData<Response<List<Category>>> = MutableLiveData()
    val myResponseRandomCat: MutableLiveData<Response<List<CatImage>>> = MutableLiveData()

    fun getCategories(){

        viewModelScope.launch {
            val response = repository.getCategories()
            myResponseCategory.value = response
        }
    }

    fun getRandomCat(){

        viewModelScope.launch {
            val response = repository.getRandomCat()
            myResponseRandomCat.value = response
        }
    }
}
